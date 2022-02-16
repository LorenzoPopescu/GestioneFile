package com.example.gestionefile;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Gestore {
    String nomeFile, esito;
    Context c;
    StringBuilder sb;

    public Gestore(){

    }

    public StringBuilder leggiFile(String nomeFile, Context c){
        try {
            String str;
            BufferedReader br = new BufferedReader(new InputStreamReader(c.openFileInput(nomeFile)));
            c.openFileInput(nomeFile);
            while((str = br.readLine()) != null){
                sb.append(br + "\n");
            }
        } catch (FileNotFoundException e) {
            Log.e("Errore", "Errore file non esistente");
        } catch (IOException e) {
            Log.e("Errore", e.toString());
        }
        return sb;
    }

    public String scriviFile(String nomefile, Context c){
        FileOutputStream fileO;
        String testodascrivere = "Questo è il testo del file";
        try {
            fileO = c.openFileOutput(nomefile, Context.MODE_PRIVATE);
            fileO.write(testodascrivere.getBytes());
            esito = "scrittura corretta";
        } catch (FileNotFoundException e) {
            esito = "Errore in scrittura";
        }catch(IOException e){
            esito = "";
        }
        return testodascrivere;
    }
}
