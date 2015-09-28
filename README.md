----------------Title

# PokerGameTDD
A poker game developed using Test Driven Development.

----------------Information

Name: Brandon Keyes
Student Number: 100 897 196
Link to GitHub project: https://github.com/brankeye/PokerGameTDD

----------------Running Instructions

--I've included both a Main.java class with a main function for running the program standardly and
--the JUnitTestSuite.java class to handle all TestClasses in my program. I assume you'll only need to
--run the test suite though. Clone the project to your workspace, then launch it in Eclipse. Locate
--the test suite class and run it.

----------------Test Methods

--------TestCard

--testStoreRankSuit

--------TestHand

--testAddCard
--testCalculateHandScore
--testIsRoyalFlush
--testIsStraightFlush
--testIsFourKind
--testIsFullHouse
--testIsFlush
--testIsStraight
--testIsThreeKind
--testIsTwoPair
--testIsPair
--testGetSortedScoreList
--testGetReverseScoreList
--testGetComparativeScoreList
--testGetCardNameString

--------TestDeck

--testAddCard
--testCheckCard

--------TestDealer

--testDealHand
--testWithinDeck
--testParseCards
--testParsePlayerID

--------TestPlayer

--testGivePlayerHand

--------TestRound

--All pass if uncommented, but Game tests do the same now anyway

--------TestGame

--testPlayGame
