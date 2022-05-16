# TradeMeApp

I tried to put up a nice architectural design for the app, but I had to rush a bit at the end. 

I have been sick since Friday and the backend service was down from last week Friday night(around 9 pm) and it came up again during the same time last week Sunday(500 - Internal server error). Plan was to tackle more of the latest listings screen during the weekend - but it didn't happen.

I think I am somewhat close to an MVP(85%). Some cosmetic work to be done. And there are more code clean ups/tidy ups and more unit tests I would say. 

I started doing this by Jetpck compose and Coroutines - since I'm still exploring them, I thought of going with Data binding and Retrofit + RxJava. 

# Technologies
Design Pattern/Architecture
- MVVM (Data Binding)

DI
- Dagger-Hilt

Network
- RxJava2
- Retrofit

Unit Tests
- JUnit4, Mockito

Other
- okhttp-signpost

-----------------------------------------------------------------------------------------------------------------------------------------------------------
# Improvements
- Couldn't really finalize the Pricing logic(I finished the BuyNowPrice scenario) in the List screen.
- Couldn't finish ordering the latest listings by Start Date.
- Couldn't complete displaying the Toasts.
- Dao/Dto Unit testing could be improved by introducing a json file to mimic server response.
- Fragment navigation could be improved by introducing a screen action queue plugin.
