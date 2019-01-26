package com.mygdx.game.JSON;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.mygdx.game.Model.Parser.Question;
import com.mygdx.game.Model.Parser.Cinematic;
import com.mygdx.game.UI.ButtonFactory;

import java.util.ArrayList;

import static com.badlogic.gdx.net.HttpRequestBuilder.json;

public class JSONParser {

    public static ArrayList<Cinematic> cinematics = new ArrayList<Cinematic>();
    public static ArrayList<Question> questions = new ArrayList<Question>();
    Question question = new Question();
    Cinematic cinematic = new Cinematic();

    JsonReader jsonReader = new JsonReader();

    JsonValue base_cin = jsonReader.parse(Gdx.files.internal(
            "cinematic.json"));
    JsonValue base_ans = jsonReader.parse(Gdx.files.internal(
            "answers.json"));

    ButtonFactory buttonFactory;

    public JSONParser() {
        Json json = new Json();
        loadCinematics();
        loadAnswers();
    }

    public void loadCinematics(){
        for(JsonValue key : base_cin.get("response")) {
            cinematic = json.fromJson(Cinematic.class, key.toString());
            cinematics.add(cinematic);
        }
    }

    public void loadAnswers(){
        for(JsonValue key : base_ans.get("response")) {
            question = json.fromJson(Question.class, key.toString());
            questions.add(question);
        }

    }
}

