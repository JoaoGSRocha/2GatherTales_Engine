package com.mygdx.game.JSON;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.mygdx.game.Model.Parser.Answer;
import com.mygdx.game.Model.Parser.Cinematic;
import com.mygdx.game.Model.Parser.Response;
import com.mygdx.game.UI.ButtonFactory;

import java.util.ArrayList;


public class JSONParser {

    public  static ArrayList<Cinematic> cinematics = new ArrayList<Cinematic>();
    public static ArrayList<Answer> answers = new ArrayList<Answer>();
    JsonReader jsonReader = new JsonReader();
    JsonValue base = jsonReader.parse(Gdx.files.internal("test.json"));
    Answer answer;
    String type = "";

    public static ArrayList<Response> AllResponse;

    ButtonFactory buttonFactory;


    public JSONParser() {
        Answer answer = new Answer();
        Cinematic cinematic = new Cinematic();
        Json json = new Json();

        for(JsonValue key : base.get("response")) {

            String type = (key.getString("type"));
            switch (type){
                case "answers":
                    answer = json.fromJson(Answer.class, key.toString());

                    break;
                case "cinematic":
                    cinematic = json.fromJson(Cinematic.class,
                        key.toString());
                    cinematics.add(cinematic);
                    break;
            }

        }
    }

}

