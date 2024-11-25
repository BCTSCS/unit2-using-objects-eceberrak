
public class Gene  
{
    private String dna;
    private int geneCount;
    public Gene(String d)
    {
        dna=d;
    }

    
    public static int findStopCodon( String genome, int start) {

        if (genome.length() % 3 != 0) {return -1;}
   
        for (int i = start; i < genome.length(); i += 3) {
            String codon = genome.substring(i, i+3);
            if (codon.equals("TAA") || codon.equals("TAG") || codon.equals("TGA")) {
                return i;
            }
        }
        return -1;}
        
    public static int countNucleotides(String g, char nucleotide){
        int count = 0;
        for(int i =0;i<g.length();i++){
            if(g.charAt(i)==nucleotide){
                count++;
            }
        }return count;
    }
    
    public static void main(String[] args) {
        System.out.println(findStopCodon("ATGCATAGCGCATAG",0));
    }
}
