## Inspiration

Having a galaxy adventure is fantastic and romantic, just like Hackathons! 
However, COVID-19 separates us from gathering together in person. 
We are all alone, staying in front of computers all day long to do our work, but we can't resist of feeling bored and unproductive without each other.
How can we stay together and get motivated? 

## What it does

Built in a hope to become ***productive*** universe-explorer together, **Pace Planet** provides the platform for everyone to join together in a team or as an indivdiaul and track the amount of studying time together to build a greater universe.
Pace Planet calculates a user's studying time using a timer and ranks the users based on the amount of their studying time. Plus, users can see the cute mascot *Pace* to study together with the users.

## How I built it

**1. Design**

- **Adobe XD** was used to create a several simple prototype of the app to build. 

**2. Functions**

- I created functions using **Android Studio** and designed the specific functions as follows:

**2.1. Track Your Time with the planet Pace**

- I used chrometer and SharedPreference to track the studying time even after the app is refreshed. The pace was changed its status based on the status of chrometer.

**2.2.  See the Online Users (who are currently studying)**

- I used **Firebase** to save each user's ID so that the status of users who opened the app can be changed to online from offline and appeared on the screen.

**2.3.  Find Team to Study Together**

- I plan to build this feature using **Firebase** again by saving the team information. 

## Challenges I ran into

I had many issues with Firebase. First, I could not connect to Firebase, and it turns out that a simple restart can resolve the issue. Then I could not add the data in the class format (that has many small components inside). I tried to submit a long string to add all necessary data, but it was unsuccessful. I reduced the scope of project and simply used one variables to build all functions related to Firebase. 
The retrieval part was also having some problems. Whenever I call the data, Firebase sends me a long string that each item is separated by a comma. I would rather want to have an organized list, but due to time limit, I simply split the string by using the comma.

Android Studio's files were too big to upload on Github at once using UI. I tried many different ways to upload the folder, and I finally found to use the Power Shell to upload the folder.

## Accomplishments that I'm proud of

It was my first time ever trying to complete the app in two days, and it brought me a lot of fun and challenges!

I am also proud of that I put extra efforts to introduce features for users as easy as possible.

## What I learned

I had difficult time using Firebase and Github, but because I tried using them so many times, now I can utilize these systems better than ever before!

I started learning how to build AR using Android Studio (as well as Unity 3D), and it was very interesting and new. 

## What's next for Pace Planet

After completing all planned components, I hope to include AR that can take a picture of the planet that users created together.
