package com.example.shoppingcart2;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ObtenerData {

    public static final String QUERY_FOR_ID_CLIENTE = "https://shopping-cart-soa.herokuapp.com/obtener_carrito_cliente/";
    Context context;
    String id_cliente;

    public ObtenerData(Context contex){
        this.context = contex;
    }

    public interface VolleyResponseListener {
        void onError(String message);
        void onResponse(List<Productos> productos);

    }

    public void getProductosById(String id_cliente, VolleyResponseListener volleyResponseListener){
        List<Productos> productosList = new ArrayList<Productos>();

        String url = QUERY_FOR_ID_CLIENTE + id_cliente;

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>(){

                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(context, response.toString(), Toast.LENGTH_SHORT).show();
                        try{
                            JSONArray carrito_list = response.getJSONArray("Carrito");
                            for(int i = 0; i <  carrito_list.length(); i++){

                                Productos productos = new Productos();
                                JSONObject productos_from_api = (JSONObject) carrito_list.get(i);

                                productos.setId_producto(productos_from_api.getInt("id_producto"));
                                productos.setNombre_producto(productos_from_api.getString("nombre_producto"));
                                productos.setProveedor(productos_from_api.getString("proveedor"));
                                productos.setPrecio_por_unidad(productos_from_api.getLong("precio_por_unidad"));
                                productos.setCantidad_de_unidades(productos_from_api.getInt("cantidad_de_unidades"));
                                productos.setUrl_imagen(productos_from_api.getString("url_imagen"));

                                productosList.add(productos);

                            }
                            volleyResponseListener.onResponse(productosList);

                        }catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context,"ocurrió un problema: " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        Singleton.getInstance(context).addToRequestQueue(request);
    }


}
