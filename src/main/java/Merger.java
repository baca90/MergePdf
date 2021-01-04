import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.PDFMergerUtility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Merger {
    public String input;
    public String output;

    public Merger(String Input, String Output){
        input = Input;
        output = Output;
    }

    public void mergeNow() throws IOException {
        System.out.println("Merging PDFs from "+input);
        System.out.println("Merged PDF will be placed at "+output);
        System.out.println("Wait...");

        List<String> fileNames = collectNames(input);
        mergePdf(fileNames);

        System.out.println("File created successfully");
    }

    public List<String> collectNames(String path){
        List<String> fileNames;
        IntStream intNames = null;
        try{
            Stream<Path> walk = Files.walk(Paths.get(path));

            List<String> names = walk.map(x -> x.getFileName().toString())
                    .filter(f -> f.endsWith(".pdf"))
                    .collect(Collectors.toList());

            names.replaceAll(n -> n.replace(".pdf", ""));

            intNames = names.stream().mapToInt(num -> Integer.parseInt(num)).sorted();
        }catch(Exception e){
            e.printStackTrace();
        }

        List<Integer> intList = intNames.boxed().collect(Collectors.toList());
        fileNames = intList.stream().map(y -> y.toString()).collect(Collectors.toList());

        return fileNames;
    }

    public void mergePdf(List<String> fileNames) throws IOException {
        PDFMergerUtility ut = new PDFMergerUtility();
        ut.setDocumentMergeMode(PDFMergerUtility.DocumentMergeMode.OPTIMIZE_RESOURCES_MODE);
        for (String fileName:fileNames
             ) {
            ut.addSource(input+"\\"+fileName+".pdf");
        }
        ut.setDestinationFileName(output);
        ut.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());
    }
}
