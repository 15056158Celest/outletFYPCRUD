package comfirebasestudentapp.example.a15056158.outletfypcrud;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("NewApi")
public class AddOutletActivity extends AppCompatActivity {

    private TextView textView;
    private String userId;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_outlet);



        }

    protected void onStart(){
        super.onStart();

    }
    public void addNewRecordButtonClicked(View view){
        EditText outletNameEditText = (EditText)findViewById(R.id.editTextOutletName);
        EditText outletLocationEditText = (EditText)findViewById(R.id.editTextOutletLocation);



        //TODO 02: Send the HttpRequest to createNewEntry.php
        Toast.makeText(AddOutletActivity.this, "Perform TODO task 2", Toast.LENGTH_SHORT).show();


        HttpRequest request = new HttpRequest("http://10.0.2.2/outlet/addOutlet.php");
        request.setMethod("POST");
        request.addData("outlet_name",outletNameEditText.getText().toString());
        request.addData("outlet_location",outletLocationEditText.getText().toString());
        request.execute();


        try{
            finish();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.display_outlet_info, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(
                    R.layout.activity_add_outlet, container, false);
            return rootView;
        }

    }
}
