package com.example.materialdesign;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_DISPLAY = 3;
    private ArrayAdapter<Employee> employeesAdapter;
    private List<Employee> employeesList = new ArrayList<>();
    private static final int SHOW_SUBACTIVITY = 1;
    private static final int REQUEST_ADD = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar(findViewById(R.id.toolbar));

        // Inicializar el adaptador de empleados
        this.employeesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, employeesList);
        initEmployeeList();

        ListView listView = findViewById(R.id.list);
        listView.setAdapter(employeesAdapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Employee employee = (Employee) parent.getItemAtPosition(position);
            Bundle bundle = new Bundle();
            bundle.putString("objectid", employee.objectId);
            bundle.putString("name", employee.Name);
            bundle.putString("surname", employee.Surname);
            Intent intent = new Intent(getApplicationContext(), DisplayActivity.class);
            intent.putExtras(bundle);
            startActivityForResult(intent, REQUEST_DISPLAY);
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            Bundle bundle = data.getExtras();
            assert bundle != null;
            String text = bundle.getString("text");
            CoordinatorLayout layout = findViewById(R.id.coordinatorLayout);

            if (requestCode == REQUEST_DISPLAY) {
                // Update
                String name = bundle.getString("name");
                String surname = bundle.getString("surname");
                String objectid = bundle.getString("objectid");
                for (Employee employee : employeesList) {
                    if (employee.objectId.equals(objectid)) {
                        employee.Name = name;
                        employee.Surname = surname;
                        break;
                    }
                }
                employeesAdapter.notifyDataSetChanged();
                Snackbar.make(layout, "Employee edited", Snackbar.LENGTH_LONG).show();

            } else if (requestCode == REQUEST_ADD) {
                // Add
                String name = bundle.getString("name");
                String surname = bundle.getString("surname");
                Employee newEmployee = new Employee(name, surname);
                newEmployee.objectId = String.valueOf(employeesList.size() + 1);
                employeesList.add(newEmployee);
                employeesAdapter.notifyDataSetChanged();
                Snackbar.make(layout, "Employee added", Snackbar.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void addItem(View view) {
        Intent intent = new Intent(getApplicationContext(), AddItemActivity.class);
        startActivityForResult(intent, REQUEST_ADD);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_reload) {
            initEmployeeList();
            employeesAdapter.notifyDataSetChanged();
            AlertDialog dialogAlert = new AlertDialog.Builder(this)
                    .setMessage("Reloaded!")
                    .setPositiveButton("Ok", null)
                    .show();
        }
        return super.onOptionsItemSelected(item);
    }

    private void initEmployeeList() {
        employeesList.clear();
        Employee employee1 = new Employee("Martin", "Martinez");
        employee1.objectId = "1";
        employeesList.add(employee1);

        Employee employee2 = new Employee("Pedro", "Perez");
        employee2.objectId = "2";
        employeesList.add(employee2);

        Employee employee3 = new Employee("Sancho", "Sanchez");
        employee3.objectId = "3";
        employeesList.add(employee3);

        Employee employee4 = new Employee("Domingo", "Dominguez");
        employee4.objectId = "4";
        employeesList.add(employee4);
    }
}
