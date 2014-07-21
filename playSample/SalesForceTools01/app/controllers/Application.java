package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Discussion;
import play.*;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {

    public static Result index() {

    	List<Discussion> discussionList = new ArrayList<Discussion>();
    	discussionList.add(new Discussion("1","PHP案件があります"));
    	discussionList.add(new Discussion("2","設計できる人をさがしています"));
    	discussionList.add(new Discussion("3","OJCPに合格しました！！"));
    	    	
        return ok(index.render("最近の話題",discussionList));

    }

}
