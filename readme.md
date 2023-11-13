# Music16 - Music Player
## Team Members:
- Son Nguyen 
- Shaoyi Ke
- Honghui Chen
- Naura Taufiq
- Vanessa Kwok

## Description
Problem Domain: Music Player
We want our application to be a Music App, so the problem domain is music. 
We are thinking of developing an application that has several tools for music listeners. 
We want the user to create a profile that will store data like music genre preference, favorite artists, 
playlist history, etc. This data will be used for tools like a recommendation bar based on a user’s history, 
a random playlist created from history/preferred genre, and many others.
We will use a Spotify API to pull the music data from.
SPOTIFY API: https://developer.spotify.com/documentation/web-api
UML Class Diagram: https://lucid.app/lucidchart/8052a492-65b0-4020-a488-52c86f6cce3c/edit?viewport_loc=-6226%2C-4667%2C1719%2C1603%2C0_0&invitationId=inv_786dad9f-a510-4840-988c-b30398f3617e


There are a lot of features that the users can use in our Music App. For our new users, they are allow to create a new
account with a username and unique password. Once the users created the account, the existing users are allowed to log
in and log out their account whenever they want. These users are also able to modify their profile account based on
their own preferences. Their profile will have their username, password, favorite music genres, and favorite artists.
With this information, our Music App will be able to give songs recommendation to the users. Our users also get few
features more like, search for specific songs/albums, explore songs by genre, comment on specific songs, and lastly, the
users would be able to follow and connect with their friends.

## TODO This week:
- [X] Each member create their own branch
- [X] 1 member modify the README.md file to include all details of the project
- [X] Split the group work
  - [X] Use Cases
  - [X] Entities
- [X] Implement the SearchTrack Use Case

## Few updates on Week 7:
- Started to write the use cases code in log in, sign up, log out
- Tried to implement the SearchTrack function
- Updated the readme.md files
- Finished our UML Class Diagram
- Made a rough sketch on the UML sequence diagram for SearchTrack

## Few updates on Week 9:
- remove the follow/unfollow attributes of the User entity
- made changes in the FavoriteArtist and FavoriteSongs attributes of the User entity
- refractored getusername() method name
- added getTrack helper class to retrieve track information when given the id of the track
- create SearchArtist class and implement the  searchArtist method

## Individual Responsibility:
- Albert: Log in use cases, getTracks method
- Will: Log out use cases, Search Artist use cases
- Son: Search Track use cases, Implement the Search interface
- Naura: Sign up use cases, add/delete genre use cases
- Vanessa: Keep the readme files updated, like/dislike tracks use cases, like/dislike artist use cases

## Tasks that needs to get done:
- add & delete favorite genre
- like/dislike artists
- like/dislike songs
- No Comments
- Check Logged_in view
- Search API call
- Fetch Spotify ID from API calls
- Store data (songs, artists) in User as list of IDs
