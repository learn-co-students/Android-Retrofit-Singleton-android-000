# Android Retrofit Singleton

Now that we've started to use retrofit, it's pretty clear we don't ever want to go back to networking without it.  Retrofit is significantly less verbose, and allows us to not worry about the low level stuff.

In our Android-Beats-Demo project, we encapsulated our Service interfaces within a class.  This is totally fine, but this made us have to make a new RestAdapter for every single API call.  We would imagine if we had a larger API, this class would get a little out of hand really quickly.

Well, there's a solution to this problem that's a little more complicated to set up, but makes using the library much less verbose.

In this project, we will wrap building our RestAdapter into a singleton.

- To start with, let's pull the interfaces that are in our BeatsService into one interface.
  * There only has to be one interface, which can hold both `getArtists` and `getArtistsAlbums`.
  * Name this interface `BeatsAPI`.  You'll see why this is a good name in a little bit.
  * This interface is a really good place to keep the `CLIENT_ID` and `BASE_API` variables
- Now that we have our one interface, we can start building our Singleton.
  * In this singleton, we're going to be using [Lazy Initialization](http://en.wikipedia.org/wiki/Singleton_pattern#Lazy_initialization).  There's two exapmples there of how to do this in Java, you should use the simpler one.
  * In a traditional Java singleton, we get a reference to the instance with `getInstance`.  In this object we're going to name this method `api`.
  * In this singleton's constructor, we should create our RestAdapter, and create + hold onto an instance of the API.  Your last line in your constructor should look something like this: `mAPI = restAdapter.create(BeatsAPI.class);`.
  * Create an accessor method for the `mAPI` variable.
  * Go back to the singleton's `api` method (the one that is usually `getInstance`), and instead of returning the actual instance, return that instance's API.
  * From outside the class, we should now be able to call `Beats.api()` and get an instance of our `BeatsAPI` inflated by Retrofit's RestAdapter.

Now that we have this set up, we can add new API methods simply by jumping into our BeatsAPI interface, and defining them.  There's no need to create a new Adapter.

## Rest Adapter
A simple query

```java
@GET("/api/artists")
public void getArtists(
    @Query("offset") Integer offset,
    @Query("limit") Integer limit,
    Callback<Base<Artist>> callback
);
```

Rest Adapter

```java
RestAdapter restAdapter = new RestAdapter.Builder()
    .setEndpoint(BeatsAPI.BASE_API)
    .setRequestInterceptor(new RequestInterceptor() {
        @Override
        public void intercept(RequestFacade request) {
            request.addQueryParam("client_id", BeatsAPI.CLIENT_ID);
        }
    })
    .build();
```
