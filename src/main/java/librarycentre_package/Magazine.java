package librarycentre_package;

public class Magazine extends Item{
    private int issueNumber;
    private String publicationFrequency;
    private String editor;

    public Magazine(String title, String ISBN){
        super(title, ISBN);
    }

    public String getTitle(){
        return super.getTitle();
    }
    public String getISBN(){
        return super.getISBN();
    }
    public String getPublicationFrequency(){
        return this.publicationFrequency;
    }
    public int getIssueNumber(){
        return this.issueNumber;
    }
    public int getPublicationYear(){
        return super.getPublicationYear();
    }
    public String getEditor(){
        return this.editor;
    }

    public void setIssueNumber(int issNum){
        issueNumber = issNum;
    }
    public void setPublicationFrequency(String freq){
        publicationFrequency = freq;
    }
    public void setEditor(String name){
        editor = name;
    }

    @Override
    public String toString(){
        return "This magazine is titled "+getTitle()+" written by "+getEditor()+" publiced on "+super.getPublicationYear();
    }


}
