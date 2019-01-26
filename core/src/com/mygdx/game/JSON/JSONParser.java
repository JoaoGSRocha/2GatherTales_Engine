package com.mygdx.game.JSON;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.mygdx.game.Model.Parser.Answer;
import com.mygdx.game.Model.Parser.Key;
import com.mygdx.game.Model.Parser.Response;
import com.mygdx.game.Model.TestModel;
import com.mygdx.game.UI.ButtonFactory;

import java.util.ArrayList;


public class JSONParser {

    ArrayList<Response> response_al = new ArrayList<Response>();
    ArrayList<Answer> answer_al = new ArrayList<Answer>();
    Response responseObj;
    TestModel testModel;
  //  public static ArrayList DataAll;
    JsonReader json = new JsonReader();
    JsonValue base = json.parse(Gdx.files.internal("response.json"));

    public static ArrayList<Response> AllResponse;

    ButtonFactory buttonFactory;

    public JSONParser() {

        for (JsonValue _responseJSON : base.get("response")) {
            Response _response = new Response();
            Key key = new Key();
          //  DataAll = _response;
            JsonValue _key = _responseJSON.get("key");
            key.setType(_key.getString("type"));
            key.setType(_key.getString("serialnumb"));

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

//                    System.out.println(answer.getText());
//
//                    System.out.println(triggerKey.getSerialnumber() + "  " + triggerKey.getType());

                    //for Cinematics



                    //for Settings

                    //for mainMenu
                }
            }

            response_al.add(_response);
        }
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

