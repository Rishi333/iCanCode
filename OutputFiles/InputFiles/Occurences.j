.class public Occurences
.super java/lang/Object

.field private static _runTimer LRunTimer;
.field private static _standardIn LPascalTextIn;

.field private static a Ljava/util/ArrayList;
.field private static currentOccurrence I
.field private static desc Ljava/lang/String;
.field private static i I
.field private static name Ljava/lang/String;
.field private static occurrences Ljava/util/HashMap;
.field private static size I
.field private static temp Ljava/lang/String;
.field private static test Z

.method public <init>()V

	aload_0
	invokenonvirtual	java/lang/Object/<init>()V
	return

.limit locals 1
.limit stack 1
.end method

.method public main()V
new  List
dup
astore_0
aload_0
invokespecial List.<init>()V
invokevirtual List/ListString()Ljava/util/ArrayList;
putstatic Occurences/a Ljava/util/ArrayList;
    ldc "a"
    putstatic Occurences/name Ljava/lang/String;
aload_0
    getstatic Occurences/name Ljava/lang/String;
invokevirtual List/add(Ljava/lang/String;)V
aload_0
    ldc "b"
invokevirtual List/add(Ljava/lang/String;)V
aload_0
    ldc "c"
invokevirtual List/add(Ljava/lang/String;)V
aload_0
    ldc "b"
invokevirtual List/add(Ljava/lang/String;)V
aload_0
    ldc "d"
invokevirtual List/add(Ljava/lang/String;)V
aload_0
    ldc "c"
invokevirtual List/add(Ljava/lang/String;)V
aload_0
    ldc "c"
invokevirtual List/add(Ljava/lang/String;)V
aload_0
    ldc "c"
invokevirtual List/add(Ljava/lang/String;)V
aload_0
    ldc "e"
invokevirtual List/add(Ljava/lang/String;)V
aload_0
invokevirtual List/getSize()I
    putstatic Occurences/size I
new Map
dup
astore_3
aload_3
invokespecial Map.<init>()V
invokevirtual Map/StringIntegerMap()Ljava/util/HashMap;
putstatic Occurences/occurrences Ljava/util/HashMap;
    ldc "Showing empty Hashmap"

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "Showing empty Hashmap"
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
aload_3
invokevirtual Map/getString()Ljava/lang/String;
    putstatic Occurences/desc Ljava/lang/String;
    ldc "HashMap "
    getstatic Occurences/desc Ljava/lang/String;

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "HashMap "
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    getstatic Occurences/desc Ljava/lang/String;
    invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    pop
    ldc 0
    putstatic Occurences/i I
L10:
    getstatic Occurences/i I
    getstatic Occurences/size I
    if_icmplt L003
    iconst_0
    goto L004
L003:
    iconst_1
L004:
    ifne L005
    goto L006
L005:
aload_0
    getstatic Occurences/i I
invokevirtual List/getValString(I)Ljava/lang/String;
    putstatic Occurences/temp Ljava/lang/String;
aload_3
    getstatic Occurences/temp Ljava/lang/String;
invokevirtual Map/contains(Ljava/lang/String;)Z
    putstatic Occurences/test Z
    getstatic Occurences/test Z
    ifeq L0026
aload_3
    getstatic Occurences/temp Ljava/lang/String;
invokevirtual Map/getValStringInteger(Ljava/lang/String;)I
    putstatic Occurences/currentOccurrence I
aload_3
    getstatic Occurences/temp Ljava/lang/String;
    getstatic Occurences/currentOccurrence I
    ldc 1
    iadd
invokevirtual Map/addStringInteger(Ljava/lang/String;I)V
    goto L00100
L0026:
    iconst_1
    ifeq L0027
aload_3
    getstatic Occurences/temp Ljava/lang/String;
    ldc 1
invokevirtual Map/addStringInteger(Ljava/lang/String;I)V
L0027:
L00100:
    getstatic Occurences/i I
    ldc 1
    iadd
    putstatic Occurences/i I
    goto L10
L006:
    ldc "Printing Generated Hash Map"

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "Printing Generated Hash Map"
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
aload_3
invokevirtual Map/getString()Ljava/lang/String;
    putstatic Occurences/desc Ljava/lang/String;
    ldc "HashMap "
    getstatic Occurences/desc Ljava/lang/String;

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "HashMap "
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    getstatic Occurences/desc Ljava/lang/String;
    invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    pop

return
.limit locals 32
.limit stack 40
.end method

.method public static main([Ljava/lang/String;)V

    new	 RunTimer
    dup
    invokenonvirtual	RunTimer/<init>()V
    putstatic	Occurences/_runTimer LRunTimer;
    new	 PascalTextIn
    dup
    invokenonvirtual	PascalTextIn/<init>()V
    putstatic	Occurences/_standardIn LPascalTextIn;

 new Occurences
    dup
    invokespecial Occurences/<init>()V
    invokevirtual Occurences/main()V

    getstatic	Occurences/_runTimer LRunTimer;
    invokevirtual	RunTimer.printElapsedTime()V

    return

.limit locals 7
.limit stack  16
.end method
