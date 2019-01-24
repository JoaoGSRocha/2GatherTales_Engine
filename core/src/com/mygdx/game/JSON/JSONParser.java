package com.mygdx.game.JSON;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.mygdx.game.Model.Parser.Response;
import com.mygdx.game.Model.TestModel;
import com.mygdx.game.UI.ButtonFactory;


public class JSONParser {

    Response response;
    TestModel testModel;

    JsonReader json = new JsonReader();
    JsonValue base = json.parse(Gdx.files.internal("response.json"));

    ButtonFactory buttonFactory;

    public JSONParser() { }

    public JSONParser(Response response){
        String type = response.getKey().getType();

        switch (type) {
            case("answer")  :
                buttonFactory.createAnswerButton_Al(response.getAnswer_al());
                break;
            case("question") :
                break;
            case("trigger") :
                break;
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

        //JsonValue Answers = base.get("response").get(0);
       // System.out.println(Answers.getString("triggers"));

//array objects in json if you would have more components
       /* for (JsonValue Key : base.get("keys"))
        {
            System.out.println(Key.getString("class"));
            System.out.println(Key.get("asset").getString("class");
            System.out.println(Key.get("asset").getString("relativePath");
        }*/
    }
}
