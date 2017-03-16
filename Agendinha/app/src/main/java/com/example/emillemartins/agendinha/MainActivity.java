package com.example.emillemartins.agendinha;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.example.emillemartins.agendinha.core.Controller;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, ClickRecyclerView_Interface {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    RecyclerTesteAdapter adapter;
    private List<Pessoa> pessoasListas = new ArrayList<>();
    private FloatingActionButton floatingActionButton;

    private TextView tv_nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();


        setaRecyclerView();

        setaButtons();
        listenersButtons();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View headerView = navigationView.getHeaderView(0);
        tv_nome = (TextView) headerView.findViewById(R.id.tv_nome);

    }

    public void setaRecyclerView() {

        //Aqui é instanciado o Recyclerview
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_recyclerteste);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        adapter = new RecyclerTesteAdapter(this, pessoasListas, this);
        mRecyclerView.setAdapter(adapter);
    }

    public void setaButtons() {

        floatingActionButton = (FloatingActionButton) findViewById(R.id.fab_fabteste);

    }

    @Override
    public void onCustomClick(Object object) {

        Pessoa pessoa = (Pessoa) object;
        String nome = pessoa.getNome();

    }

    /**
     * Chama os listeners para os botões
     */
    public void listenersButtons() {

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Cria uma nova pessoa chamada Renan Teles
                Pessoa pessoa1 = new Pessoa();
                pessoa1.setNome("Emille Martins");
                //Pessoa pessoa2 = new Pessoa();
                //pessoa2.setNome("Micael Lopes");
                //Pessoa pessoa3 = new Pessoa();
                //pessoa3.setNome("Vinicius Andrade");

                //Adiciona a pessoa1 e avisa o adapter que o conteúdo
                //da lista foi alterado
                pessoasListas.add(pessoa1);
                //pessoasListas.add(pessoa2);
                //pessoasListas.add(pessoa3);
                adapter.notifyDataSetChanged();

            }
        });
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.menu1) {
            //chama a tela de configuracoes
            Intent intent = new Intent(getApplicationContext(), ConfigActivity.class);
            startActivity(intent);

        } else if (id == R.id.menu2) {
            //chama a tela da pag web
            Intent intent = new Intent(getApplicationContext(), SiteActivity.class);
            startActivity(intent);

        } else if (id == R.id.sair) {
            // volta p tela de login
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //CHAMA A TELA DO PERFIL QND CLICA NO NOME DO USUARIO
    public void PerfilActivity(View view) {
        Intent intent = new Intent(MainActivity.this, PerfilActivity.class);
        startActivity(intent);

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (Controller.getInstance().getValue() != null) {
            tv_nome.setText(Controller.getInstance().getValue());
        }


    }
}
