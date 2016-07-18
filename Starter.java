class Starter {

	public static void main(String[] params) {

	//Check to make sure that a valid file was passed.
		if(params.length != 1 || !params[0].matches(".+\\.bf$")) {
			System.out.println(filename + " is not a valid brainfuck program (.bf)");
			System.exit(0);
		}

		String filename = params[0];

		try {

			Scanner sc = new Scanner(new File(filename));

			checkSyntax(sc);

			Interpreter interpreter = new Interpreter(bffile);

		}
		catch(FileNotFoundException e){

			System.out.println(filename + " can not be found.");
			System.exit(0);
		}
	}

	private static void checkSyntax(Scanner file) {
		int brack = 0;
		int lnumb = 1;
		String line;

		while(file.hasNextLine()) {
			
			line = file.nextLine();

			for(int i = 0; i < line.length; i++) {
				c = line.charAt(i);

				if(c == '[')
					brack++;
				else if(c == ']')
					brack--;

				if(brack < 0) {
					System.out.println("Syntax Error: Unmatched ']' on line " + lnumb);
					System.exit(0);
				}
			}

			lnumb++;
		}
		
		if(brack > 0) {
			System.out.println("Syntax Error:" + brack + " unmatched '['");
			System.exit(0);
		}
	}
}
