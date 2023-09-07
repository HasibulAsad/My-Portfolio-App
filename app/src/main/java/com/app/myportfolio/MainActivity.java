package com.app.myportfolio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayDeque;
import java.util.Deque;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    Deque<Integer> integerDeque = new ArrayDeque<>(5);
    boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        loadFragment(new HomeFragment());
        bottomNavigationView.setSelectedItemId(R.id.idhome);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();

                if (integerDeque.contains(id)) {
                    if (id == R.id.idhome) {
                        if (integerDeque.size() != 0) {
                            if (flag) {
                                integerDeque.addFirst(R.id.idhome);
                                flag = false;
                            }
                        }
                    }
                    integerDeque.remove(id);
                }
                integerDeque.push(id);
                loadFragment(getFragment(item.getItemId()));
                return true;
            }

        });

    }

    private Fragment getFragment(int itemid) {
        if (itemid == R.id.idhome) {
            bottomNavigationView.getMenu().getItem(0).setChecked(true);
            return new HomeFragment();
        } else if (itemid == R.id.idprofile) {
            bottomNavigationView.getMenu().getItem(1).setChecked(true);
            return new ProfileFragment();
        } else if (itemid == R.id.idportfolio) {
            bottomNavigationView.getMenu().getItem(2).setChecked(true);
            return new PortfolioFragment();
        } else if (itemid == R.id.idmessage) {
            bottomNavigationView.getMenu().getItem(3).setChecked(true);
            return new MessageFragment();
        } else if (itemid == R.id.idchat) {
            bottomNavigationView.getMenu().getItem(4).setChecked(true);
            return new ChatFragment();
        }
        bottomNavigationView.getMenu().getItem(0).setChecked(true);
        return new HomeFragment();
    }

    public void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment, fragment.getClass().getSimpleName())
                .commit();
    }

    @Override
    public void onBackPressed() {
        integerDeque.pop();
        if (!integerDeque.isEmpty()) {
            loadFragment(getFragment(integerDeque.peek()));
        } else {
            finish();
        }
    }
}