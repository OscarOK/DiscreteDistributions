package com.oscarok.discretedistributions;

import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.oscarok.discretedistributions.distributions.Poisson;
import com.oscarok.discretedistributions.fragments.BinomialFragment;
import com.oscarok.discretedistributions.fragments.MultinomialFragment;
import com.oscarok.discretedistributions.fragments.GeometricFragment;
import com.oscarok.discretedistributions.fragments.NegativeFragment;
import com.oscarok.discretedistributions.fragments.PoissonFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        BinomialFragment.OnFragmentInteractionListener,
        MultinomialFragment.OnFragmentInteractionListener,
        GeometricFragment.OnFragmentInteractionListener,
        NegativeFragment.OnFragmentInteractionListener,
        PoissonFragment.OnFragmentInteractionListener {

    private short fragmentIndex;
    private EditText etSuccess;
    private EditText etExperiments;
    private EditText etProbability;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (fragmentIndex) {
                    case 0:

                    case 1:
                        checkBinomialInput();
                    case 2:

                    case 3:
                        checkBinomialInput();
                    case 4:
                        checkGeometricInput();
                    case 5:
                        if (checkPoissonInput()) {
                            Poisson poisson = new Poisson(Double.parseDouble(etProbability.getText().toString()),
                                    Double.parseDouble(etExperiments.getText().toString()),
                                    Integer.parseInt(etSuccess.getText().toString()));

                            Toast.makeText(MainActivity.this, String.format("La probabilidad es %f", poisson.resu()), Toast.LENGTH_SHORT).show();
                        }
                }
            }
        });
        fab.setVisibility(View.GONE);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.getMenu().getItem(0).setChecked(true);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private boolean checkBinomialInput() {
        boolean erika = true;
        etSuccess = findViewById(R.id.input_success);
        etExperiments = findViewById(R.id.input_experiments);
        etProbability = findViewById(R.id.input_probability);

        if (etSuccess.getText().toString().isEmpty()) {
            etSuccess.setError(getResources().getString(R.string.error_input));
            erika = false;
        }

        if (etExperiments.getText().toString().isEmpty()) {
            etExperiments.setError(getResources().getString(R.string.error_input));
            erika = false;
        }

        if (etProbability.getText().toString().isEmpty()) {
            etProbability.setError(getResources().getString(R.string.error_input));
            erika = false;
        }

        try {
            if (Integer.parseInt(etSuccess.getText().toString()) > Integer.parseInt(etExperiments.getText().toString())) {
                Toast.makeText(this, getResources().getString(R.string.error_success_greater), Toast.LENGTH_SHORT).show();
                erika = false;
            }

            if (Double.parseDouble(etProbability.getText().toString()) > 1) {
                Toast.makeText(this, getResources().getString(R.string.error_probability), Toast.LENGTH_SHORT).show();
                erika = false;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        return erika;
    }

    private boolean checkPoissonInput() {
        boolean erika = true;
        etSuccess = findViewById(R.id.input_success);
        etExperiments = findViewById(R.id.input_experiments);
        etProbability = findViewById(R.id.input_probability);

        if (etSuccess.getText().toString().isEmpty()) {
            etSuccess.setError(getResources().getString(R.string.error_input));
            erika = false;
        }

        if (etExperiments.getText().toString().isEmpty()) {
            etExperiments.setError(getResources().getString(R.string.error_input));
            erika = false;
        }

        if (etProbability.getText().toString().isEmpty()) {
            etProbability.setError(getResources().getString(R.string.error_input));
            erika = false;
        }

        return erika;
    }

    private boolean checkGeometricInput() {
        boolean erika = true;
        etExperiments = findViewById(R.id.input_experiments);
        etProbability = findViewById(R.id.input_probability);

        if (etExperiments.getText().toString().isEmpty()) {
            etExperiments.setError(getResources().getString(R.string.error_input));
            erika = false;
        }

        if (etProbability.getText().toString().isEmpty()) {
            etProbability.setError(getResources().getString(R.string.error_input));
            erika = false;
        }

        try {
            if (Double.parseDouble(etProbability.getText().toString()) > 1) {
                Toast.makeText(this, getResources().getString(R.string.error_probability), Toast.LENGTH_SHORT).show();
                erika = false;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        return erika;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        item.setCheckable(true);
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (id == R.id.nav_overview) {
            fragmentIndex = 0;
            findViewById(R.id.fab).setVisibility(View.GONE);
            getSupportActionBar().setTitle(getResources().getString(R.string.app_name));
        } else if (id == R.id.nav_geometric) {
            fragmentIndex = 4;
            getSupportActionBar().setTitle(getResources().getString(R.string.geometric_dis));
            fragmentManager.beginTransaction().replace(R.id.content_frame, new GeometricFragment()).commit();
        } else if (id == R.id.nav_binomial) {
            fragmentIndex = 1;
            getSupportActionBar().setTitle(getResources().getString(R.string.binomial_dis));
            fragmentManager.beginTransaction().replace(R.id.content_frame, new BinomialFragment()).commit();
        } else if (id == R.id.nav_poisson) {
            fragmentIndex = 5;
            getSupportActionBar().setTitle(getResources().getString(R.string.poisson_dis));
            fragmentManager.beginTransaction().replace(R.id.content_frame, new PoissonFragment()).commit();
        } else if (id == R.id.nav_negative) {
            fragmentIndex = 3;
            getSupportActionBar().setTitle(getResources().getString(R.string.negative_dis));
            fragmentManager.beginTransaction().replace(R.id.content_frame, new NegativeFragment()).commit();
        } else if (id == R.id.nav_multinomial) {
            fragmentIndex = 2;
            getSupportActionBar().setTitle(getResources().getString(R.string.multinomial_dis));
            fragmentManager.beginTransaction().replace(R.id.content_frame, new MultinomialFragment()).commit();
        }

        if (fragmentIndex != 0) {
            findViewById(R.id.fab).setVisibility(View.VISIBLE);
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
