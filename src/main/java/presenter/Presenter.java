package presenter;

import model_weither_api.WeitherService;
import view_ui.View;

public class Presenter {
    private View view;
    private WeitherService service;

    public Presenter(View view) {
        this.view = view;
        service = new WeitherService();
    }
    public void getInfo(String city){
        String answer = service.getWeither(city);
        view.printAnswer(answer);
    }
}
