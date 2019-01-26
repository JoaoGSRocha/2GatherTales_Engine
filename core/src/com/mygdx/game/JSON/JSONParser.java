package com.mygdx.game.JSON;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.mygdx.game.Model.Parser.Answer;
import com.mygdx.game.Model.Parser.Key;
import com.mygdx.game.Model.Parser.Response;
import com.mygdx.game.UI.ButtonFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class JSONParser {

    HashMap<Key, Response> responseHashMap = new HashMap<Key, Response>();
    HashMap<Key, Response> cinematicHashMap = new HashMap<Key, Response>();
    HashMap<Key, Response> answerHashMap = new HashMap<Key, Response>();
    ArrayList<Key> keys = new ArrayList<Key>();
    JsonReader jsonReader = new JsonReader();
    JsonValue base = jsonReader.parse(Gdx.files.internal("response2.json"));

    String type = "";

    public static ArrayList<Response> AllResponse;

    ButtonFactory buttonFactory;

    public ArrayList<Key> getKeys() { return keys; }

    public void setKeys(ArrayList<Key> keys) { this.keys = keys; }

    public JSONParser() {
        Response response = new Response();
        Json json = new Json();


        Key key = json.fromJson(Key.class, Gdx.files.internal(
                "test.json"));
        for (JsonValue _responseJSON : base.get("response")) {

            Response _response = new Response();

            keys = findAllKeys();

            answerHashMap = findAllAnswers();

            Iterator hmIterator = answerHashMap.entrySet().iterator();

            // Iterate through the hashmap
            // and add some bonus marks for every student

            while (hmIterator.hasNext()) {
                Map.Entry mapElement = (Map.Entry)hmIterator.next();
                Response answer_resp = ((Response) mapElement.getValue());
                System.out.println(mapElement.getKey() + " : "
                        + answer_resp.getAnswer_al().get(0).getText()
                        + " "+ answer_resp.getKey().getType());
            }
        }
    }

    //COMPLETED
    public ArrayList<Key> findAllKeys(){
        ArrayList<Key> keys = new ArrayList<Key>();
        for (JsonValue _responseJSON : base.get("response")) {
            Key key = new Key();
            //  DataAll = _response;
            JsonValue _key = _responseJSON.get("key");
            key.setType(_key.getString("type"));
            key.setSerialnumber(_key.getInt("serialnumb"));
            keys.add(key);
        }
        return keys;
    }


    public HashMap<Key, Response> findAllAnswers(){
        HashMap<Key, Response> responses = new HashMap<Key, Response>();
        HashMap<Key, Answer> answers = new HashMap<Key, Answer>();
        for (JsonValue _responseJSON : base.get("response")) {
            Response response = new Response();

            if (_responseJSON.get("answers") != null) {
                for (JsonValue _answer : _responseJSON.get("answers")) {
                    Answer answer = new Answer();
                    answer.setText(_answer.getString("text"));
                    //Create Key based on arguemtns
                    JsonValue _triggerKey = _answer.get("trigger");
                    Key triggerKey = new Key();
                    triggerKey.setSerialnumber(_triggerKey.getInt(
                            "serialnumb"));
                    triggerKey.setType(_triggerKey.getString("type"));

                     answer.setTriggerKey(compareKey(triggerKey, getKeys()));

                     answers.put(answer.getTriggerKey(), answer);
                }
                Key key = new Key();
                key.setSerialnumber(_responseJSON.get("key").getInt(
                        "serialnumb"));
                key.setType(_responseJSON.get("type").getString(
                        "type"));
                response.setKey(compareKey(key, keys));
                response.setAnswer_al(answers);
            }

            responses.put(response.getKey(), response);
        }
        return responses;
    }

    public Key compareKey(Key targetKey, ArrayList<Key> keys){

        //Cycle through the arraylist of keys
        for(Key key : keys){
            if(key.getType().equals(targetKey.getType()))
                if(key.getSerialnumber() == targetKey.getSerialnumber())
                    return  key;
        }
        return  null;
    }

    public JSONParser(Response response) {
            String type = response.getKey().getType();

            for (JsonValue _responseJSON : base.get("response")) {
                Response _response = new Response();
                Key key = new Key();

                for (JsonValue _key : _responseJSON.get("Key")) {
                    key.setType(_key.getString("type"));
                    key.setType(_key.getString("serialnumb"));
                }

                if(_responseJSON.getString("answers")!= null){
                    for(JsonValue _answer : _responseJSON.get("answers")){
                        Answer answer = new Answer();
                        answer.setText(_answer.getString("text"));


                        //Create Key based on arguemtns
                        for(JsonValue _triggerKey : _responseJSON.get("trigger")) {
                            Key triggerKey = new Key();
                            triggerKey.setSerialnumber(_triggerKey.getInt(
                                    "serialnumb"));
                            triggerKey.setType(_triggerKey.getString("type"));
                            System.out.println(triggerKey.getSerialnumber()+"  "+triggerKey.getType());
                        }

                    }

                    //for Cinematics

                    //for Settings

                    //for mainMenu
                }


                //For each element of the ArrayList
                //decide which buttonFactory to call

                switch ( response.getKey().getType()){
                    case "answer":
                        buttonFactory
                                .createAnswerButton_Al(
                                        response.getAnswer_al());
                    case "cinematic":
                        buttonFactory
                                .createCinematicButton_Al(
                                        response.getCinematic_al());
                    case "settings":
                        response.getKey().getType();
                    case "mainMenu":
                        response.getKey().getType();
                    default:
                        System.out.println("default");
                }


            }
        }

        public void load() {

            Response resposta = new Response();


            //get the component values
            JsonValue response = base.get("response").get(0);

            //print class value to console



            //JsonValue Answers = base.get("responseObj").get(0);
            // System.out.println(Answers.getString("triggers"));
        }
    }

