.class public Game
.super java/lang/Object

.field private static _runTimer LRunTimer;
.field private static _standardIn LPascalTextIn;

.field private static classChoice Ljava/lang/String;
.field private static continueGame Z
.field private static foundNumber Z
.field private static input I
.field private static success Z
.field private static weaponOne Ljava/lang/String;
.field private static weaponTwo Ljava/lang/String;

.method public <init>()V

	aload_0
	invokenonvirtual	java/lang/Object/<init>()V
	return

.limit locals 1
.limit stack 1
.end method

.method public declareVariables()V
    ldc 0
    putstatic Game/input I
    ldc ""
    putstatic Game/weaponOne Ljava/lang/String;
    ldc ""
    putstatic Game/weaponTwo Ljava/lang/String;
    ldc ""
    putstatic Game/classChoice Ljava/lang/String;

return
.limit locals 32
.limit stack 40
.end method

.method public main()V
    ldc 1
    putstatic Game/continueGame Z
L10:
    getstatic Game/continueGame Z
    ldc 1
    if_icmpeq L003
    iconst_0
    goto L004
L003:
    iconst_1
L004:
    ifne L005
    goto L006
L005:
    new Game
    dup
    invokespecial Game/<init>()V
    invokevirtual Game/StartJourney()V
    new Game
    dup
    invokespecial Game/<init>()V
    invokevirtual Game/BattleMonster()V
    new Game
    dup
    invokespecial Game/<init>()V
    invokevirtual Game/PlayPredict()V
    ldc "You have been enlightened physically and mentally"

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "You have been enlightened physically and mentally"
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    ldc "Do you want to reach enlightenment with another Class or quit"

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "Do you want to reach enlightenment with another Class or quit"
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    ldc "1 Play Again with same or new Hero"

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "1 Play Again with same or new Hero"
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    ldc "2 quit"

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "2 quit"
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    new Game
    dup
    invokespecial Game/<init>()V
    invokevirtual Game/inputInt()V
    getstatic Game/input I
    ldc 1
    if_icmpne L0015
    iconst_0
    goto L0016
L0015:
    iconst_1
L0016:
    ifeq L0018
    ldc 0
    putstatic Game/continueGame Z
    goto L00100
L0018:
L00100:
    goto L10
L006:

return
.limit locals 32
.limit stack 40
.end method

.method public PlayPredict()V
    ldc "You have reached the House of a Fortune Teller"

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "You have reached the House of a Fortune Teller"
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    ldc "You go in and the fortune teller agrees to train you in prediction"

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "You go in and the fortune teller agrees to train you in prediction"
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    ldc "The fortune teller says I have picked a number from one to a thousand"

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "The fortune teller says I have picked a number from one to a thousand"
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    ldc "Can you guess my number"

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "Can you guess my number"
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    ldc 0
    putstatic Game/foundNumber Z
L20:
    getstatic Game/foundNumber Z
    ldc 0
    if_icmpeq L0020
    iconst_0
    goto L0021
L0020:
    iconst_1
L0021:
    ifne L0022
    goto L0023
L0022:
    new Game
    dup
    invokespecial Game/<init>()V
    invokevirtual Game/inputInt()V
    getstatic Game/input I
    ldc 276
    if_icmpeq L0032
    iconst_0
    goto L0033
L0032:
    iconst_1
L0033:
    ifeq L0035
    ldc "You have predicted the fortune tellers number very quickly"

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "You have predicted the fortune tellers number very quickly"
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    ldc "You are enlightened in the field of mentalism"

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "You are enlightened in the field of mentalism"
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    ldc ""

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc ""
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    ldc ""

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc ""
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    ldc 1
    putstatic Game/foundNumber Z
    goto L00101
L0035:
    getstatic Game/input I
    ldc 400
    if_icmpgt L0036
    iconst_0
    goto L0037
L0036:
    iconst_1
L0037:
    ifeq L0038
    ldc "You have guessed too high"

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "You have guessed too high"
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    ldc "Guess Again and learn to Become one with nature"

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "Guess Again and learn to Become one with nature"
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    goto L00101
L0038:
    getstatic Game/input I
    ldc 200
    if_icmplt L0039
    iconst_0
    goto L0040
L0039:
    iconst_1
L0040:
    ifeq L0041
    ldc "You have guessed too low"

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "You have guessed too low"
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    ldc "Guess Again and feel the force"

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "Guess Again and feel the force"
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    goto L00101
L0041:
    getstatic Game/input I
    ldc 276
    if_icmpgt L0042
    iconst_0
    goto L0043
L0042:
    iconst_1
L0043:
    ifeq L0044
    ldc "You have guessed high but you are close"

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "You have guessed high but you are close"
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    ldc "guess again and a clue that one of the numbers is a 7"

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "guess again and a clue that one of the numbers is a 7"
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    goto L00101
L0044:
    getstatic Game/input I
    ldc 276
    if_icmplt L0045
    iconst_0
    goto L0046
L0045:
    iconst_1
L0046:
    ifeq L0047
    ldc "You have guessed low but you are close"

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "You have guessed low but you are close"
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    ldc "Guess Again and one of the numbers is a 6"

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "Guess Again and one of the numbers is a 6"
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    goto L00101
L0047:
L00101:
    goto L20
L0023:

return
.limit locals 32
.limit stack 40
.end method

.method public BattleMonster()V
    ldc "You have started your journey "
    getstatic Game/classChoice Ljava/lang/String;

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "You have started your journey "
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    getstatic Game/classChoice Ljava/lang/String;
    invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    pop
    ldc 0
    putstatic Game/success Z
    ldc "A Wild Centaur Appears and is About to Attack"

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "A Wild Centaur Appears and is About to Attack"
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    ldc "What will you do"

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "What will you do"
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
L30:
    getstatic Game/success Z
    ldc 1
    if_icmpne L0049
    iconst_0
    goto L0050
L0049:
    iconst_1
L0050:
    ifne L0051
    goto L0052
L0051:
    ldc "1 Attack with "
    getstatic Game/weaponOne Ljava/lang/String;

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "1 Attack with "
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    getstatic Game/weaponOne Ljava/lang/String;
    invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    pop
    ldc "2 Attack with "
    getstatic Game/weaponTwo Ljava/lang/String;

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "2 Attack with "
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    getstatic Game/weaponTwo Ljava/lang/String;
    invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    pop
    ldc "3 Try to Reason with the beast"

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "3 Try to Reason with the beast"
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    new Game
    dup
    invokespecial Game/<init>()V
    invokevirtual Game/inputInt()V
    getstatic Game/input I
    ldc 1
    if_icmpeq L0061
    iconst_0
    goto L0062
L0061:
    iconst_1
L0062:
    ifeq L0064
    ldc "The Centaur Dodged your "
    getstatic Game/weaponOne Ljava/lang/String;

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "The Centaur Dodged your "
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    getstatic Game/weaponOne Ljava/lang/String;
    invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    pop
    goto L00102
L0064:
    getstatic Game/input I
    ldc 2
    if_icmpeq L0065
    iconst_0
    goto L0066
L0065:
    iconst_1
L0066:
    ifeq L0067
    ldc "You have killed the beast and continue your journey"

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "You have killed the beast and continue your journey"
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    ldc "You are enlightened in the field of physical defense and offense"

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "You are enlightened in the field of physical defense and offense"
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    ldc ""

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc ""
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    ldc 1
    putstatic Game/success Z
    goto L00102
L0067:
    getstatic Game/input I
    ldc 3
    if_icmpeq L0068
    iconst_0
    goto L0069
L0068:
    iconst_1
L0069:
    ifeq L0070
    ldc "The Beast has stopped and argues Kantian ethics"

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "The Beast has stopped and argues Kantian ethics"
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    ldc "The Beast sees its impossible to live if he universally does not attack you"

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "The Beast sees its impossible to live if he universally does not attack you"
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    ldc "Thus he must still commence battle"

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "Thus he must still commence battle"
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    goto L00102
L0070:
L00102:
    goto L30
L0052:

return
.limit locals 32
.limit stack 40
.end method

.method public StartJourney()V
    ldc "You have started on a journey to enlightenment"

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "You have started on a journey to enlightenment"
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    ldc "Your journey starts with you choosing your class"

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "Your journey starts with you choosing your class"
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    ldc "Do you want to be a"

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "Do you want to be a"
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    ldc "1 Mage"

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "1 Mage"
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    ldc "2 Warrior"

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "2 Warrior"
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    ldc "3 Thief"

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "3 Thief"
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    new Game
    dup
    invokespecial Game/<init>()V
    invokevirtual Game/declareVariables()V
    new Game
    dup
    invokespecial Game/<init>()V
    invokevirtual Game/inputInt()V
    getstatic Game/input I
    ldc 1
    if_icmpeq L0072
    iconst_0
    goto L0073
L0072:
    iconst_1
L0073:
    ifeq L0075
    ldc "You have chosen the Mage"

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "You have chosen the Mage"
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    new Game
    dup
    invokespecial Game/<init>()V
    invokevirtual Game/CreateMage()V
    goto L00103
L0075:
    getstatic Game/input I
    ldc 2
    if_icmpeq L0076
    iconst_0
    goto L0077
L0076:
    iconst_1
L0077:
    ifeq L0078
    ldc "You have chosen Warrior"

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "You have chosen Warrior"
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    new Game
    dup
    invokespecial Game/<init>()V
    invokevirtual Game/CreateWarrior()V
    goto L00103
L0078:
    getstatic Game/input I
    ldc 3
    if_icmpeq L0079
    iconst_0
    goto L0080
L0079:
    iconst_1
L0080:
    ifeq L0081
    ldc "You have chosen Thief"

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "You have chosen Thief"
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    new Game
    dup
    invokespecial Game/<init>()V
    invokevirtual Game/CreateThief()V
    goto L00103
L0081:
L00103:

return
.limit locals 32
.limit stack 40
.end method

.method public CreateWarrior()V
    ldc "Warrior"
    putstatic Game/classChoice Ljava/lang/String;
    ldc "Battle Axe"
    putstatic Game/weaponOne Ljava/lang/String;
    ldc "Great Sword"
    putstatic Game/weaponTwo Ljava/lang/String;

return
.limit locals 32
.limit stack 40
.end method

.method public CreateMage()V
    ldc "Mage"
    putstatic Game/classChoice Ljava/lang/String;
    ldc "Fire Bolt"
    putstatic Game/weaponOne Ljava/lang/String;
    ldc "Frost Bolt"
    putstatic Game/weaponTwo Ljava/lang/String;

return
.limit locals 32
.limit stack 40
.end method

.method public CreateThief()V
    ldc "Thief"
    putstatic Game/classChoice Ljava/lang/String;
    ldc "Dagger"
    putstatic Game/weaponOne Ljava/lang/String;
    ldc "Long Bow"
    putstatic Game/weaponTwo Ljava/lang/String;

return
.limit locals 32
.limit stack 40
.end method

.method public inputInt()V
    ldc "Please enter a valid Number"

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "Please enter a valid Number"
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    getstatic Game/_standardIn LPascalTextIn;
    invokevirtual PascalTextIn.readInteger()I
    putstatic Game/input I
    ldc ""

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc ""
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    ldc ""

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc ""
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    ldc ""

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc ""
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    ldc "CONTINUED HERE"

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "CONTINUED HERE"
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop

return
.limit locals 32
.limit stack 40
.end method

.method public static main([Ljava/lang/String;)V

    new	 RunTimer
    dup
    invokenonvirtual	RunTimer/<init>()V
    putstatic	Game/_runTimer LRunTimer;
    new	 PascalTextIn
    dup
    invokenonvirtual	PascalTextIn/<init>()V
    putstatic	Game/_standardIn LPascalTextIn;

 new Game
    dup
    invokespecial Game/<init>()V
    invokevirtual Game/main()V

    getstatic	Game/_runTimer LRunTimer;
    invokevirtual	RunTimer.printElapsedTime()V

    return

.limit locals 7
.limit stack  16
.end method
