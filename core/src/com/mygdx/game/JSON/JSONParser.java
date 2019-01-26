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


public class JSONParser {

    HashMap<Key, Response> responseHashMap = new HashMap<Key, Response>();
    HashMap<Key, Response> cinematicHashMap = new HashMap<Key, Response>();
    HashMap<Key, Response> answerHashMap = new HashMap<Key, Response>();
    ArrayList<Key> keys = new ArrayList<Key>();
    JsonReader jsonReader = new JsonReader();
    JsonValue base = jsonReader.parse(Gdx.files.internal("test.json"));

    String type = "";

    public static ArrayList<Response> AllResponse;

    ButtonFactory buttonFactory;

    public ArrayList<Key> getKeys() {
        return keys;
    }

    public void setKeys(ArrayList<Key> keys) {
        this.keys = keys;
    }

    public JSONParser() {
        Response response = new Response();
        Json json = new Json();

        for(JsonValue key : base.get("response")) {
            Answer answer = json.fromJson(Answer.class, key.toString());
            System.out.println(answer.getText()+" type "+answer.getType()+ " " +
                    "serial "+ answer.getSerialnumber());
        }
    }
}

