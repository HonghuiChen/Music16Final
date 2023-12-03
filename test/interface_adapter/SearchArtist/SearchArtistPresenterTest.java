package interface_adapter.SearchArtist;

import interface_adapter.homeScreen.HomeScreenViewModel;
import org.junit.jupiter.api.Test;
import use_case.SearchArtist.SearchArtistOutputData;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SearchArtistPresenterTest {

    @Test
    void prepareSuccessViewTest() {
        HomeScreenViewModel homeScreenViewModel = new HomeScreenViewModel();


        ArrayList<String> genres = new ArrayList<>();
        genres.add("detroit hip hop");
        genres.add("hip hop");
        genres.add("rap");
        SearchArtistOutputData outputData =
                new SearchArtistOutputData("Eminem", genres, "79179575 followers");

        SearchArtistPresenter presenter = new SearchArtistPresenter(homeScreenViewModel);

        presenter.prepareSuccessView(outputData);

        assertEquals(homeScreenViewModel.getState().getOutput(), outputBuilder(outputData.getOutput()));

    }

    @Test
    void prepareFailViewTest() {
        HomeScreenViewModel homeScreenViewModel = new HomeScreenViewModel();

        String error = "Sorry, we couldn't find this artist.";
        ArrayList<String> errorlist = new ArrayList<>();
        errorlist.add(error);

        SearchArtistPresenter presenter = new SearchArtistPresenter(homeScreenViewModel);

        presenter.prepareFailView(error);

        assertEquals(homeScreenViewModel.getState().getOutput(), outputBuilder(errorlist));

    }





    static String outputBuilder(ArrayList<String> output) {

        StringBuilder outputBuilder = new StringBuilder();
        for (Object x : output) {
            outputBuilder.append(x);
            outputBuilder.append("\n");
        }
        return outputBuilder.toString();

    }

}