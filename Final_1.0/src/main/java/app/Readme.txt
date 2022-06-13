Zadání práce:

	Můj program bude analyzovat údaje o tepové frekvenci a laktátu při zátěži. 
Vstupy budou dva samostatné soubory - soubor srdeční frekvence a soubor laktátu. 
Soubor s tepovou frekvencí bude soubor txt, jehož každý řádek bude obsahovat číslo, které představuje tepovou frekvenci v b/m. 
Číslo může být v desítkovém nebo binárním formátu a oba formáty lze v jednom souboru používat střídavě. 
Soubor s laktátem bude soubor txt, jehož každý řádek bude obsahovat číslo, které představuje hladinu laktátu v mmol/l. 
Číslo může být v desítkovém nebo binárním formátu ale oba formáty nelze v jednom souboru používat střídavě.
Soubory budou mít vždy stejné názvy - hrdata.txt a lactatedata.txt.
Program umožní uživateli vytvořit graf s údaji o srdeční frekvenci nebo s údaji o laktátu, případně s oběma údaji současně. 
Graf bude viditelný na obrazovce a uloží se také jako vektorovou grafiku ve formátu pdf.


Funkční specifikace:

	-Graf závislosti tepové frekvence na čase
	-Graf závislosti hladiny laktátu na čase
	-Graf tepové frekvence a laktátu v závislosti na čase


Popis struktury vstupních souborů:

	-Soubor s tepovou frekvencí bude soubor hrdata.txt, a jehož každý řádek bude obsahovat 1 číslo(desítkové nebo binární). Soubor bude uloženy v \src\main\java\data
	-Soubor s laktátem bude soubor lactatedata.txt, a jehož každý řádek bude obsahovat 1 číslo. Všechna čísla budou buď binární, nebo desítkové. Soubor bude uloženy v \src\main\java\data


Popis struktury výstupních souborů:

	-Graf s tepovou frekvencí bude soubor hrGraph.pdf a bude uloženy v \src\main\java\data
	-Graf s laktátem bude soubor lactateGraph.pdf a bude uloženy v \src\main\java\data
	-Graf s tepovou frekvencí a laktátem bude soubor doubleGraph.pdf a bude uloženy v \src\main\java\data


Class diagram:

	\src\main\java\data\FinalProjectDiagram.drawio.html

Javadoc:
	
	\target\site\apidocs\allpackages-index.html


Popis fungování externí knihovny:
	
	Základní graf lze vytvořit pomocí:

		XYChart chartName = QuickChart.getChart("Title", "X Title", "Y Title", "Legend Title", xData, yData);	

	Graf lze ukázat pomocí:

		new SwingWrapper(chartName).displayChart();

	Graf lze ukládat pomocí:
	
		VectorGraphicsEncoder.saveVectorGraphic(chartName, "Directory", VectorGraphicsFormat.PDF);

	Lze zabránit tomu, aby graf ukončil program, když je uzavřen pomocí:

		.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE)

	-chartName je zvolený název objektu grafu
	-Title je název grafu
	-X Title je název osy x
	-Y Title je název osy y
	-Legend Title je název křivky v legendě
	-xData je Array s daty X v formatu Double
	-yData je Array s daty Y v formatu Double
	-Directory je adresář pro uložení 


	Další podrobnosti na: 
		-https://knowm.org/javadocs/xchart/index.html 
		-https://knowm.org/open-source/xchart/xchart-example-code/