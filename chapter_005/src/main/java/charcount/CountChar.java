package charcount;

public class CountChar {
    private String line;
    private int spacesCount = 0;
    private int wordsCount = 0;


    class CountSpacesThread implements Runnable {

        @Override
        public void run() {
            countSpaces();
            System.out.println("spaces = " + spacesCount);
        }
    }

    class CountWordsThread implements Runnable {

        @Override
        public void run() {
            countWords();
            System.out.println("words = " + wordsCount);
        }
    }

    public CountChar(String line) {
        this.line = line;
    }

    private void countSpaces() {
        for (char s : this.line.toCharArray()) {
            if (s == ' ') {
                this.spacesCount++;
            }
        }
    }

    private void countWords() {
        char[] line = this.line.toCharArray();
        int res = 0;
        for (int i = 1; i < line.length; i++) {
            if (line[i] == ' ' && line[i - 1] != ' ') {
                res++;
            }
        }
        this.wordsCount = ++res;
    }


    public void count() {
        Thread spacesThread = new Thread(new CountSpacesThread());
        Thread wordsThread = new Thread(new CountWordsThread());
        spacesThread.start();
        wordsThread.start();
    }

    public static void main(String[] args) {
        CountChar countChar = new CountChar("123 sdf sdaf");
        countChar.count();
    }

}
