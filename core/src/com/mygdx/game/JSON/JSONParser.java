package com.mygdx.game.JSON;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.mygdx.game.Model.Parser.Response;
import com.mygdx.game.Model.TestModel;
import com.mygdx.game.UI.ButtonFactory;

import java.util.ArrayList;


public class JSONParser {

    ArrayList<Response> response_al = new ArrayList<Response>();
    Response responseObj;
    TestModel testModel;

    JsonReader json = new JsonReader();
    JsonValue base = json.parse(Gdx.files.internal("response.json"));

    ButtonFactory buttonFactory;

    public JSONParser() {
    }

    public JSONParser(Response response) {
        String type = response.getKey().getType();

        for (JsonValue _response : base.get("response")) {
            System.out.println(_response.getString("question"));
            for (JsonValue _key : _response.get("Key")) {
                System.out.println(_key.getString("type"));
                System.out.println(_key.getInt("serialnumb"));
            }
            //For each element of the ArrayList
            //decide which buttonFactory to call
            switch (type) {
                case ("answer"):
                    buttonFactory.createAnswerButton_Al(response.getAnswer_al());
                    break;
                case ("cinematic"):
                    buttonFactory.createAnswerButton_Al(response.getAnswer_al());
                    break;
                case ("settings"):
                    buttonFactory.createAnswerButton_Al(response.getAnswer_al());
                    break;
                case ("mainmenu"):
                    buttonFactory.createAnswerButton_Al(response.getAnswer_al());
                    break;
            }
        }
    }

    public void load() {

        Response resposta = new Response();

        System.out.println(base);

        //get the component values
        JsonValue response = base.get("response").get(0);

        //print class value to console
        System.out.println(response.getString("question"));

        System.out.println(response.get("answers"));

        System.out.println(response.get("triggers"));

        //JsonValue Answers = base.get("responseObj").get(0);
        // System.out.println(Answers.getString("triggers"));
    }
}

