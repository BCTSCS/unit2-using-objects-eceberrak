
public class Gene  
{
    private String dna;
    private int geneCount;
    public Gene(String d)
    {
        dna=d;
    }

    
    static int findStopCodon( String genome, int start) {

        if (genome.length() % 3 != 0) {return -1;}
   
        for (int i = start; i < genome.length(); i += 3) {
            String codon = genome.substring(i, i+3);
            if (codon.equals("TAA") || codon.equals("TAG") || codon.equals("TGA")) {
                return i;
            }
        }
        return -1;}
    
    public static void main(String[] args) {
        System.out.println(findStopCodon("ATGCATAGCGCATAG",0));
    }
}
