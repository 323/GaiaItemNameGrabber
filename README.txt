The GING (Gaia Item Name Grabber) is a simple Gaia Online marketplace tool.

It grabs the names of items based off of a range of Item IDs.

For example, if you picked the IDs 100 through 1000, it would find all of the items with the IDs between 100 and 1000 and save them into a text file, which has the item's name and ID.

In the ~/src folder you'll find the source code
In the ~/bin folder you'll find the binaries which you can run.

A note on the source code: To compile it, you need Isonyx's HTTPRequest Java HTTP Wrappers (You can find them here: https://github.com/Isonyx/HTTPRequest)

Along with Apache's Commons Lang (Which can be found here: http://commons.apache.org/proper/commons-lang/)

Note: The .txt file in the ~/bin folder is an example output. First you see the Item ID, and then after that the item's name.

Enjoy!