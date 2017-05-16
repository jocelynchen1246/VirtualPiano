# VirtualPiano
Ivy Huang, Jocelyn Chen, Natalie Tarn
05-06-17

PianoSimulator

Introduction

The user will use various keys on the computer keyboard in order to play a piece of music on a virtual piano (can also be played by clicking on key with mouse).  The notes will be shown in a waterfall (colored rectangles fall from the top of the screen down and eventually line up with keys on the keyboard located below, indicating to the player which notes are to be played) format, and the player presses the corresponding “keys” on the computer. A final accuracy percentage/score will be shown after the piece ends.  The program utilizes Jfugue and its components for functionality/usage. JFugue allows for notes to be played out loud, and also has  built in RealTime Player (used for the virtual keyboard) that reads what the player types to play the notes.

Instructions

Lower C: tab 
C#/Db: 1
D: q
D#/Eb: 2
E: w
F: e
F#/Gb: 4
G: r
G#/Ab: 5
A: t
A#/Bb: 6
B: y
Middle C: u
C#/Db: 8
D: i
D#/Eb: 9
E: o
F: p
F#/Gb: -
G: [
G#/Ab: =
A: ]
A#/Bb: backspace
B: enter
Upper C: \

Features

Must haves: 
A working virtual keyboard: when keys on the keyboard is pressed, the corresponding note plays with realistic piano sounds (long notes and slight fade). 
A functional “waterfall” format for at least one song, where notes (denoted by rectangular bars) with corresponding note length falls down on the notes 
Aforementioned rectangular bars line up with corresponding piano keys 
A roughly accurate score estimate shows up on the screen after each song ends.
Rank the player’s personal scores

Wants: 
Key turns different color when played, and reverts back after note is released.
Learning: Short piano piece where next key to be played lights up.
A repertoire of pieces for waterfall notes.
Be able to choose the type of instrument sound that is heard when the song plays (ie saxophone, clarinet, flute)
High Score Table with everyone in the class’s scores, ranked
Left hand extra keyboard (below the regular keyboard)

Extras: 
Play against someone else in the room, have their score and your score pop up afterwards to show who has won (multiplayer mode)
Feature that lets player “compose” their own music that’s savable in a file.
Read piano music from files on computer and implement into learning/waterfall mode
One song with sheet music rolling across the screen 
Pedal function
Dampening function
Classes:
-Keyboard: Computer/Piano keyboard 
-Key: Each note is represented by a key, and the keyboard has multiple keys
-Main: Main method, creates an instance of the overall game
-Waterfall: Represents the “waterfall” format of the game (notes represented by rectangular bars fall in in line with the notes on the keyboard)(stores notes with how long each note is).
-TitleScreen- Home screen where users can choose to play the virtual keyboard, learn a new song, or play against others 
-Score (accuracy): calculates and displays the overall accuracy/amount correct after each song (how many correct notes were played out of the total)
-Instructions (screen): extends JFrame, displays instructions for the game
-KeyboardScreen: Virtual keyboard without waterfall learning
-WaterfallScreen: Screen with waterfall learning (notes coming down) and keyboard
-ScoreScreen: Displays the player’s score rankings after a song


Roles:
Ivy: Keyboard graphics, sheet music functioning/scrolling, main menu/displays
	-Keyboard (drawing part if u want or i can do it), TitleScreen, WaterfallScreen

Jocelyn: Jfugue functioning (piano keyboard with computer keyboard)
	-Keyboard, Key, Main

Natalie: “score”/ “accuracy” calculator, Jfugue functioning
	-ScoreScreen, Score, Waterfall, Main

All: Class design


Suggestions:
Add a few more interesting features because this is very similar to some existing games
Try to combine classes to make everything accessible. Score, Waterfall, and Key are not accessible from the Main class currently
Where is the song played?
