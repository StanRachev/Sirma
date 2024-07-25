# String Tasks
Several tasks related to manipulating Strings using methods from the String class and regex. 

## Description
1. **Reverse Strings** - Enter a series of strings until an "end" command. Prints each string alongside its reverse version.
2. **Repeat Strings** - Each string in an array is repeat n times (where n is the length of the string) and prints the concatenated result.
3. **Substring** - removing all occurrences of the first string from the second string until no matches are found, then prints the remaining string.

    **Input**
    - First line - string
    - Second line - string

4. **Text Filter** - replaces banned words in a text with asterisks (*), where the number of asterisks equals the length of the banned word.

    **Input**
    - First line - list with ban words
    - Second line - text

5. **Digits, Letters and Other** - receives a single string and prints:
    - First line - digits
    - Second line - letters
    - Third line - special characters

    There should always be at least one digit, letter and another character.

6. **Valid Usernames** - reads usernames on a single line (joined by ", ") and prints all valid usernames. 

    - Length: 3 - 16
    - Contains: letters, numbers, hyphens, and underscores

7. **Extract File** - reads a path to a file and subtracts the file name and its extension. (Name: homework. Extension: .pdf)
8. **Caesar Cipher** - encrypting the text by shifting each character with three positions forward.
9. **Multiply Big Number** - Multiplying a large number (up to 1050 digits) by a single-digit number without using the BigInteger class.
10. **Replace Repeating Chars** - replaces any sequence of the same letters in a string with a single corresponding letter.
11. **Extract Person Information** - extracting and printing the name and age from lines of strings where:

    - Name is between @ and |
    - Age is between # and *

12. **Ascii Sumator** - calculating the sum of ASCII values of characters in a string that are between two given characters.

    **Input**:
    - First line - the first character
    - Second line - the second character
    - Third line - the String

    **Output**:
    - the sum.

13. **Morse Code Translator** - translates messages from Morse code to English (in capital letters). 
14. **HTML** - Converts article information and comments to HTML format.
    
    **Input**:
    - First line - Title
    - Second line - Content
    - Third line - Comments (subsequent lines until "end of comments")
    
    **Output**:
    - Title: Enclosed in `<h1></h1>`
    - Content: Enclosed in `<article></article>`
    - Comments: Each comment enclosed in `<div></div>`

15. **Letter** - Receives two arrays. One contains text with holes (every hole has a certain length). Second array contains words which length matches with those of the holes. The task is to fill the text.
16. **Match Full Name** - Matching full name from a list. To be valid it has two names, starts with capital letter and are separated by a single space.
17. **Match Phone Number** - using regex, this program matches a valid phone number from Sofia. The different parts are separated by either a space or a hyphen. (+359 2 666 6666, +359-6-666-6666)
18. **Pascal-Case Splitter** - splits a PascalCase string into words.
19. **Match Dates** - This program uses a regex pattern to match dates, ensuring the separator is consistent with each date and extracts the day, month and year.

    **Input**:  
    07/Oct/1992, 15-01-1990, , 01/Jan-1951,17.03.1992, 23#09#1973, 1/Feb/2016

    **Output**:  
    Day: 07, Month: Oct, Year: 1992  
    Day: 15, Month: Jan, Year: 1990  
    Day: 17, Month: Mar, Year: 1992


20. **Star Battles Enigma** - a game to decrypt messages. 
    1. Counting occurrences of the letters 's', 't', 'a', 'r' (case insensitive)
    2. Subtracting the key value from each character's ASCII code.
    3. Details:
        - Planet Name - starts after '@'
        - Population - starts after ':'
        - Attack Type 'A' for attack or 'D' for destruction, enclosed in '!!'
        - Soldier Count starts after '->'

    **Input**:
    - First Line - number of messages, 𝑛 (1 to 100).
    - Next 𝑛 lines - encrypted messages.

    **Output**:
    - Print the attacked planets and destroyed planets in the given format.

    #### Example:

    **Input**:  
    3  
    STCDoghudd4=63333$D$0A53333  
    EHfsytsnhf?8555&I&2C9555SR  
    GQhytvnvij5:75557!A!3B75557TU  

    **Output**:  
    Attacked planets: 2  
    -> Pluto  
    -> Endor  
    Destroyed planets: 1  
    -> Manatoria  