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
    private FileHandle file = Gdx.files.local("response.json");

    ButtonFactory buttonFactory;

    public JSONParser() { }

    public JSONParser(Response response){
        String type = response.getKey().getType();

        switch (type) {
            case("answer")  :
                buttonFactory.createAnswerButton(response.getAnswer_al());
                break;
            case("question") :
                break;
            case("trigger") :
                break;
        }


    }

    public void load() {
        System.out.println(base);
    }
}
