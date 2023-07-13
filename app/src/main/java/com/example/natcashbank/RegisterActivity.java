package com.example.natcashbank;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;

import com.example.natcashbank.databinding.ActivityRegisterBinding;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.textfield.TextInputLayout;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class RegisterActivity extends AppCompatActivity {
    private ActivityRegisterBinding binding;
    private static final String MY_SHARE_PREFERENCE = "MY_SHARE_PREFERENCE";
    private static final String KEY_PHONE = "KEY_PHONE";
    private static final String KEY_NAME = "KEY_NAME";

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getGender();
        getDatePicker();
        getData();

        sharedPreferences = getSharedPreferences(MY_SHARE_PREFERENCE, MODE_PRIVATE);

    }

    private void getData() {
        sharedPreferences = getSharedPreferences(MY_SHARE_PREFERENCE, MODE_PRIVATE);

        String phone = sharedPreferences.getString(KEY_PHONE, null);
        if (phone != null) {
            binding.txtPhoneLog.setText(phone);
        }

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(KEY_NAME,binding.txtFullName.getText().toString());
                editor.apply();

                Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });
    }

    private void getDatePicker() {

        Calendar cal = Calendar.getInstance();
        binding.Picker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        RegisterActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                // Lưu giá trị ngày được chọn vào biến Calendar
                                cal.set(Calendar.YEAR, year);
                                cal.set(Calendar.MONTH, month);
                                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                                // Cập nhật giá trị ngày trong TextInputEditText
                                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                                String formattedDate = dateFormat.format(cal.getTime());
                                binding.Picker.setText(formattedDate);
                            }
                        },
                        cal.get(Calendar.YEAR),
                        cal.get(Calendar.MONTH),
                        cal.get(Calendar.DAY_OF_MONTH)
                );

                datePickerDialog.show();
            }
        });

    }

    private void getGender() {
        List<String> items = Arrays.asList("Male", "Female", "Other");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_text, items);
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) binding.textField.getEditText();
        if (autoCompleteTextView instanceof AutoCompleteTextView) {
            autoCompleteTextView.setAdapter(adapter);
        }
    }

}