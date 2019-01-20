package com.mygdx.game.JSON;

import com.mygdx.game.Model.Parser.Response;
import com.mygdx.game.UI.ButtonFactory;

public class JSONParser {

    ButtonFactory buttonFactory;

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
}
