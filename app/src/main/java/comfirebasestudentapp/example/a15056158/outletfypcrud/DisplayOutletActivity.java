package comfirebasestudentapp.example.a15056158.outletfypcrud;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;

@SuppressLint("NewApi")
public class DisplayOutletActivity extends AppCompatActivity {

    private String Id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_outlet);



    }

    protected void onStart(){
        super.onStart();
        Intent intent = getIntent();
        Id = intent.getStringExtra("com.example.MAIN_MESSAGE");
        HttpRequest request= new HttpRequest("http://10.0.2.2/outlet/getOutletDetail.php?Id=" + Id);
        request.setMethod("GET");
        request.execute();

        try{
            String jsonString = request.getResponse();
            JSONObject jsonObj = new JSONObject(jsonString);
            // TODO 01: Set values in the EditText fields

            EditText outletNameET = (EditText)findViewById(R.id.editTextOutletName);
            outletNameET.setText(jsonObj.getString("outlet_name"));
            EditText outletLocationET = (EditText)findViewById(R.id.editTextOutletLocation);
            outletLocationET.setText(jsonObj.getString("outlet_location"));


        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateDetailsButtonClicked(View view){
        EditText outletNameEditText = (EditText)findViewById(R.id.editTextOutletName);
        EditText outletLocationEditText = (EditText)findViewById(R.id.editTextOutletLocation);


        //TODO 03: Send the HttpRequest to updateContact.php
        Toast.makeText(DisplayOutletActivity.this, "Perform TODO task 3", Toast.LENGTH_SHORT).show();

        HttpRequest request = new HttpRequest("http://10.0.2.2/outlet/updateOutlet.php");
        request.setMethod("POST");
        request.addData("outlet_name",outletNameEditText.getText().toString());
        request.addData("outlet_location",outletLocationEditText.getText().toString());
        request.addData("id", Id);

        request.execute();



        try{

            finish();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void deleteRecordButtonClicked(View view){
        //TODO 04: Send HttpRequest to removeContact.php
        Toast.makeText(DisplayOutletActivity.this, "Perform TODO task 4", Toast.LENGTH_SHORT).show();
        HttpRequest request = new HttpRequest("http://10.0.2.2/outlet/deleteOutlet.php");
        request.setMethod("POST");


        request.addData("id", Id);
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
                    R.layout.activity_display_outlet, container, false);
            return rootView;
        }

    }
}
