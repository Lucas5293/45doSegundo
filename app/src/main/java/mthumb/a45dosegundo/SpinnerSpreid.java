ackage mthumb.a45dosegundo;
        import android.app.Activity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.Spinner;
        import java.util.List;
        import java.util.ArrayList;

public class SpinnerSpreid extends Activity {

    private Spinner spn1;
    private List<String> nomes = new ArrayList<String>();
    private String nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_header_main);

        //Adicionando Nomes no ArrayList
        nomes.add("Palmeiras");
        nomes.add("Corinthians");
        nomes.add("São Paulo");
        nomes.add("Santos");
        nomes.add("Flamengo");

        //Identifica o Spinner no layout
        spn1 = (Spinner) findViewById(R.id.spinner_times);
        //Cria um ArrayAdapter usando um padrão de layout da classe R do android, passando o ArrayList nomes
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, nomes);
        ArrayAdapter<String> spinnerArrayAdapter = arrayAdapter;
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spn1.setAdapter(spinnerArrayAdapter);

        //Método do Spinner para capturar o item selecionado
        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int posicao, long id) {
                //pega nome pela posição
                nome = parent.getItemAtPosition(posicao).toString();
                //Troca todas as informações do APP de acordo com o time

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

}