Objectives
In this stage, program should:

Ask users what they want to do, encode a string, decode a string or quit the program with
Please input operation (encode/decode/exit):
If user inputs encode as the desired operation, the program should print Input string: to the output, read a line and output two lines — Encoded string: followed by the encoded string;
If user inputs decode as the desired operation, the program should print Input encoded string: to the output, read a line and output two lines — Decoded string: followed by the actual decoded string;
If user inputs exit as the desired operation, the program should say Bye! and finish its execution.
The program should be looped to terminate only if the user inputs exit as an operation. Otherwise, it should continue asking users Please input operation (encode/decode/exit): after each iteration.

Also, prevent some incorrect input.

If the user misspells the operation name, the program should print out There is no '<input>' operation
If the user provided an incorrect encoded message as input to decode, the program should print out appropriate feedback containing not valid substring

List of not valid encoded messages:

The encoded message includes characters other than 0 or spaces;
The first block of each sequence is not 0 or 00;
The number of blocks is odd;
The length of the decoded binary string is not a multiple of 7.
