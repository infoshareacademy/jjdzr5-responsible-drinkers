package com.infoshareacademy.drinkers.domain.drink;

import javax.validation.constraints.Size;
import java.net.URI;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Drink {

    private int idDrink;

    @Size(min = 2, max = 35, message = "{walidacja.nazwa}")
    private String strDrink;
    private String strDrinkAlternate;
    private String strTags;
    private String strVideo;

    @Size(min = 2, max = 25, message = "{walidacja.kategoria}")
    private String strCategory;
    private String strIBA;
    private String strAlcoholic;

    @Size(min = 2, max = 25, message = "{walidacja.nazwa}")
    private String strGlass;

    @Size(min = 2, max = 250, message = "{walidacja.przepis}")
    private String strInstructions;
    private String strInstructionsES;
    private String strInstructionsDE;
    private String strInstructionsFR;
    private String strInstructionsIT;
    private String strInstructionsZH_HANS;
    private String strInstructionsZH_HANT;
    private URI strDrinkThumb;

    @Size(min = 2, max = 25, message = "{walidacja.skladnik}")
    private String strIngredient1;

    @Size(min = 2, max = 25, message = "{walidacja.skladnik}")
    private String strIngredient2;

    private String strIngredient3;
    private String strIngredient4;
    private String strIngredient5;
    private String strIngredient6;
    private String strIngredient7;
    private String strIngredient8;
    private String strIngredient9;
    private String strIngredient10;
    private String strIngredient11;
    private String strIngredient12;
    private String strIngredient13;
    private String strIngredient14;
    private String strIngredient15;
    private String strMeasure1;
    private String strMeasure2;
    private String strMeasure3;
    private String strMeasure4;
    private String strMeasure5;
    private String strMeasure6;
    private String strMeasure7;
    private String strMeasure8;
    private String strMeasure9;
    private String strMeasure10;
    private String strMeasure11;
    private String strMeasure12;
    private String strMeasure13;
    private String strMeasure14;
    private String strMeasure15;
    private URI strImageSource;
    private String strImageAttribution;
    private String strCreativeCommonsConfirmed;
    private LocalDateTime dateModified;

    public String getStrGlass() {
        return strGlass;
    }

    public void setStrGlass(String strGlass) {
        this.strGlass = strGlass;
    }

    public String getStrCategory() {
        return strCategory;
    }

    public void setStrCategory(String strCategory) {
        this.strCategory = strCategory;
    }

    public String getStrIngredient1() {
        return strIngredient1;
    }

    public String getStrInstructions() {
        return strInstructions;
    }

    public void setStrInstructions(String strInstructions) {
        this.strInstructions = strInstructions;
    }

    public void setStrIngredient1(String strIngredient1) {
        this.strIngredient1 = strIngredient1;
    }

    public String getStrIngredient2() {
        return strIngredient2;
    }

    public URI getStrDrinkThumb() {
        return strDrinkThumb;
    }

    public void setStrDrinkThumb(URI strDrinkThumb) {
        this.strDrinkThumb = strDrinkThumb;
    }

    public void setStrIngredient2(String strIngredient2) {
        this.strIngredient2 = strIngredient2;
    }

    public String getStrDrink() {
        return strDrink;
    }

    public void setStrDrink(String strDrink) {
        this.strDrink = strDrink;
    }

    public List<String> getIngredients() {
        List<String> result = new ArrayList<>();
        if (getIngredient1() != null) {
            result.add(getIngredient1());
        }
        if (getIngredient2() != null) {
            result.add(getIngredient2());
        }
        if (getIngredient3() != null) {
            result.add(getIngredient3());
        }
        if (getIngredient4() != null) {
            result.add(getIngredient4());
        }
        if (getIngredient5() != null) {
            result.add(getIngredient5());
        }
        if (getIngredient6() != null) {
            result.add(getIngredient6());
        }
        if (getIngredient7() != null) {
            result.add(getIngredient7());
        }
        if (getIngredient8() != null) {
            result.add(getIngredient8());
        }
        if (getIngredient9() != null) {
            result.add(getIngredient9());
        }
        if (getIngredient10() != null) {
            result.add(getIngredient10());
        }
        if (getIngredient11() != null) {
            result.add(getIngredient11());
        }
        if (getIngredient12() != null) {
            result.add(getIngredient12());
        }
        if (getIngredient13() != null) {
            result.add(getIngredient13());
        }
        if (getIngredient14() != null) {
            result.add(getIngredient14());
        }
        if (getIngredient15() != null) {
            result.add(getIngredient15());
        }
        return result;
    }

    public List<Instruction> getInstructionList() {
        List<Instruction> result = new ArrayList<>();
        if (getInstructionsDE() != null) {
            result.add(new Instruction(getInstructionsDE(), InstructionsLanguage.DE));
        }
        if (getInstructions() != null) {
            result.add(new Instruction(getInstructions(), InstructionsLanguage.EN));
        }
        if (getInstructionsES() != null) {
            result.add(new Instruction(getInstructionsES(), InstructionsLanguage.ES));
        }
        if (getInstructionsIT() != null) {
            result.add(new Instruction(getInstructionsDE(), InstructionsLanguage.IT));
        }
        if (getInstructionsFR() != null) {
            result.add(new Instruction(getInstructionsFR(), InstructionsLanguage.FR));
        }
        if (getInstructionsZH_HANS() != null) {
            result.add(new Instruction(getInstructionsZH_HANS(), InstructionsLanguage.ZH_HANS));
        }
        if (getInstructionsZH_HANT() != null) {
            result.add(new Instruction(getInstructionsZH_HANT(), InstructionsLanguage.ZH_HANT));
        }
        return result;
    }

    public String getStringIntredientrs() {
        StringBuilder strIngredients = new StringBuilder();
        for (String s : getIngredients()) {
            if (strIngredients.toString().isEmpty() || strIngredients.toString().replace(" ", "").isBlank()) {
                strIngredients = new StringBuilder(s);
            } else {
                strIngredients.append(", ").append(s);
            }
        }
        return strIngredients.toString();
    }

    public Integer getIdDrink() {
        return idDrink;
    }

    public void setIdDrink(int idDrink) {
        this.idDrink = idDrink;
    }

    public String getDrink() {
        return strDrink;
    }

    public void setDrinkName(String strDrink) {
        this.strDrink = strDrink;
    }

    public String getDrinkAlternate() {
        return strDrinkAlternate;
    }

    public void setDrinkAlternate(String strDrinkAlternate) {
        this.strDrinkAlternate = strDrinkAlternate;
    }

    public String getTags() {
        return strTags;
    }

    public void setTags(String strTags) {
        this.strTags = strTags;
    }

    public String getVideo() {
        return strVideo;
    }

    public void setVideo(String strVideo) {
        this.strVideo = strVideo;
    }

    public String getCategory() {
        return strCategory;
    }

    public void setCategory(String strCategory) {
        this.strCategory = strCategory;
    }

    public String getIBA() {
        return strIBA;
    }

    public void setIBA(String strIBA) {
        this.strIBA = strIBA;
    }

    public String getAlcoholic() {
        return strAlcoholic;
    }

    public void setAlcoholic(String strAlcoholic) {
        this.strAlcoholic = strAlcoholic;
    }

    public String getGlass() {
        return strGlass;
    }

    public void setGlass(String strGlass) {
        this.strGlass = strGlass;
    }

    public String getInstructions() {
        return strInstructions;
    }

    public void setInstructions(String strInstructions) {
        this.strInstructions = strInstructions;
    }

    public String getInstructionsES() {
        return strInstructionsES;
    }

    public void setInstructionsES(String strInstructionsES) {
        this.strInstructionsES = strInstructionsES;
    }

    public String getInstructionsDE() {
        return strInstructionsDE;
    }

    public void setInstructionsDE(String strInstructionsDE) {
        this.strInstructionsDE = strInstructionsDE;
    }

    public String getInstructionsFR() {
        return strInstructionsFR;
    }

    public void setInstructionsFR(String strInstructionsFR) {
        this.strInstructionsFR = strInstructionsFR;
    }

    public String getInstructionsIT() {
        return strInstructionsIT;
    }

    public void setInstructionsIT(String strInstructionsIT) {
        this.strInstructionsIT = strInstructionsIT;
    }

    public String getInstructionsZH_HANS() {
        return strInstructionsZH_HANS;
    }

    public void setInstructionsZH_HANS(String strInstructionsZH_HANS) {
        this.strInstructionsZH_HANS = strInstructionsZH_HANS;
    }

    public String getInstructionsZH_HANT() {
        return strInstructionsZH_HANT;
    }

    public void setInstructionsZH_HANT(String strInstructionsZH_HANT) {
        this.strInstructionsZH_HANT = strInstructionsZH_HANT;
    }

    public URI getDrinkThumb() {
        return strDrinkThumb;
    }

    public void setDrinkThumb(URI strDrinkThumb) {
        this.strDrinkThumb = strDrinkThumb;
    }

    public String getIngredient1() {
        return strIngredient1;
    }

    public void setIngredient1(String strIngredient1) {
        this.strIngredient1 = strIngredient1;
    }

    public String getIngredient2() {
        return strIngredient2;
    }

    public void setIngredient2(String strIngredient2) {
        this.strIngredient2 = strIngredient2;
    }

    public String getIngredient3() {
        return strIngredient3;
    }

    public void setIngredient3(String strIngredient3) {
        this.strIngredient3 = strIngredient3;
    }

    public String getIngredient4() {
        return strIngredient4;
    }

    public void setIngredient4(String strIngredient4) {
        this.strIngredient4 = strIngredient4;
    }

    public String getIngredient5() {
        return strIngredient5;
    }

    public void setIngredient5(String strIngredient5) {
        this.strIngredient5 = strIngredient5;
    }

    public String getIngredient6() {
        return strIngredient6;
    }

    public void setIngredient6(String strIngredient6) {
        this.strIngredient6 = strIngredient6;
    }

    public String getIngredient7() {
        return strIngredient7;
    }

    public void setIngredient7(String strIngredient7) {
        this.strIngredient7 = strIngredient7;
    }

    public String getIngredient8() {
        return strIngredient8;
    }

    public void setIngredient8(String strIngredient8) {
        this.strIngredient8 = strIngredient8;
    }

    public String getIngredient9() {
        return strIngredient9;
    }

    public void setIngredient9(String strIngredient9) {
        this.strIngredient9 = strIngredient9;
    }

    public String getIngredient10() {
        return strIngredient10;
    }

    public void setIngredient10(String strIngredient10) {
        this.strIngredient10 = strIngredient10;
    }

    public String getIngredient11() {
        return strIngredient11;
    }

    public void setIngredient11(String strIngredient11) {
        this.strIngredient11 = strIngredient11;
    }

    public String getIngredient12() {
        return strIngredient12;
    }

    public void setIngredient12(String strIngredient12) {
        this.strIngredient12 = strIngredient12;
    }

    public String getIngredient13() {
        return strIngredient13;
    }

    public void setIngredient13(String strIngredient13) {
        this.strIngredient13 = strIngredient13;
    }

    public String getIngredient14() {
        return strIngredient14;
    }

    public void setIngredient14(String strIngredient14) {
        this.strIngredient14 = strIngredient14;
    }

    public String getIngredient15() {
        return strIngredient15;
    }

    public void setIngredient15(String strIngredient15) {
        this.strIngredient15 = strIngredient15;
    }

    public String getMeasure1() {
        return strMeasure1;
    }

    public void setMeasure1(String strMeasure1) {
        this.strMeasure1 = strMeasure1;
    }

    public String getMeasure2() {
        return strMeasure2;
    }

    public void setMeasure2(String strMeasure2) {
        this.strMeasure2 = strMeasure2;
    }

    public String getMeasure3() {
        return strMeasure3;
    }

    public void setMeasure3(String strMeasure3) {
        this.strMeasure3 = strMeasure3;
    }

    public String getMeasure4() {
        return strMeasure4;
    }

    public void setMeasure4(String strMeasure4) {
        this.strMeasure4 = strMeasure4;
    }

    public String getMeasure5() {
        return strMeasure5;
    }

    public void setMeasure5(String strMeasure5) {
        this.strMeasure5 = strMeasure5;
    }

    public String getMeasure6() {
        return strMeasure6;
    }

    public void setMeasure6(String strMeasure6) {
        this.strMeasure6 = strMeasure6;
    }

    public String getMeasure7() {
        return strMeasure7;
    }

    public void setMeasure7(String strMeasure7) {
        this.strMeasure7 = strMeasure7;
    }

    public String getMeasure8() {
        return strMeasure8;
    }

    public void setMeasure8(String strMeasure8) {
        this.strMeasure8 = strMeasure8;
    }

    public String getMeasure9() {
        return strMeasure9;
    }

    public void setMeasure9(String strMeasure9) {
        this.strMeasure9 = strMeasure9;
    }

    public String getMeasure10() {
        return strMeasure10;
    }

    public void setMeasure10(String strMeasure10) {
        this.strMeasure10 = strMeasure10;
    }

    public String getMeasure11() {
        return strMeasure11;
    }

    public void setMeasure11(String strMeasure11) {
        this.strMeasure11 = strMeasure11;
    }

    public String getMeasure12() {
        return strMeasure12;
    }

    public void setMeasure12(String strMeasure12) {
        this.strMeasure12 = strMeasure12;
    }

    public String getStrMeasure13() {
        return strMeasure13;
    }

    public void setMeasure13(String strMeasure13) {
        this.strMeasure13 = strMeasure13;
    }

    public String getMeasure14() {
        return strMeasure14;
    }

    public void setMeasure14(String strMeasure14) {
        this.strMeasure14 = strMeasure14;
    }

    public String getMeasure15() {
        return strMeasure15;
    }

    public void setMeasure15(String strMeasure15) {
        this.strMeasure15 = strMeasure15;
    }

    public URI getImageSource() {
        return strImageSource;
    }

    public void setImageSource(URI strImageSource) {
        this.strImageSource = strImageSource;
    }

    public String getImageAttribution() {
        return strImageAttribution;
    }

    public void setImageAttribution(String strImageAttribution) {
        this.strImageAttribution = strImageAttribution;
    }

    public String getCreativeCommonsConfirmed() {
        return strCreativeCommonsConfirmed;
    }

    public void setCreativeCommonsConfirmed(String strCreativeCommonsConfirmed) {
        this.strCreativeCommonsConfirmed = strCreativeCommonsConfirmed;
    }

    public LocalDateTime getDateModified() {
        return dateModified;
    }

    public void setDateModified(LocalDateTime dateModified) {
        this.dateModified = dateModified;
    }

    public Drink copyOf() {
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Drink drink = (Drink) o;
        return idDrink == drink.idDrink && Objects.equals(strDrink, drink.strDrink) && Objects.equals(strDrinkAlternate, drink.strDrinkAlternate) && Objects.equals(strTags, drink.strTags) && Objects.equals(strVideo, drink.strVideo) && Objects.equals(strCategory, drink.strCategory) && Objects.equals(strIBA, drink.strIBA) && Objects.equals(strAlcoholic, drink.strAlcoholic) && Objects.equals(strGlass, drink.strGlass) && Objects.equals(strInstructions, drink.strInstructions) && Objects.equals(strInstructionsES, drink.strInstructionsES) && Objects.equals(strInstructionsDE, drink.strInstructionsDE) && Objects.equals(strInstructionsFR, drink.strInstructionsFR) && Objects.equals(strInstructionsIT, drink.strInstructionsIT) && Objects.equals(strInstructionsZH_HANS, drink.strInstructionsZH_HANS) && Objects.equals(strInstructionsZH_HANT, drink.strInstructionsZH_HANT) && Objects.equals(strDrinkThumb, drink.strDrinkThumb) && Objects.equals(strIngredient1, drink.strIngredient1) && Objects.equals(strIngredient2, drink.strIngredient2) && Objects.equals(strIngredient3, drink.strIngredient3) && Objects.equals(strIngredient4, drink.strIngredient4) && Objects.equals(strIngredient5, drink.strIngredient5) && Objects.equals(strIngredient6, drink.strIngredient6) && Objects.equals(strIngredient7, drink.strIngredient7) && Objects.equals(strIngredient8, drink.strIngredient8) && Objects.equals(strIngredient9, drink.strIngredient9) && Objects.equals(strIngredient10, drink.strIngredient10) && Objects.equals(strIngredient11, drink.strIngredient11) && Objects.equals(strIngredient12, drink.strIngredient12) && Objects.equals(strIngredient13, drink.strIngredient13) && Objects.equals(strIngredient14, drink.strIngredient14) && Objects.equals(strIngredient15, drink.strIngredient15) && Objects.equals(strMeasure1, drink.strMeasure1) && Objects.equals(strMeasure2, drink.strMeasure2) && Objects.equals(strMeasure3, drink.strMeasure3) && Objects.equals(strMeasure4, drink.strMeasure4) && Objects.equals(strMeasure5, drink.strMeasure5) && Objects.equals(strMeasure6, drink.strMeasure6) && Objects.equals(strMeasure7, drink.strMeasure7) && Objects.equals(strMeasure8, drink.strMeasure8) && Objects.equals(strMeasure9, drink.strMeasure9) && Objects.equals(strMeasure10, drink.strMeasure10) && Objects.equals(strMeasure11, drink.strMeasure11) && Objects.equals(strMeasure12, drink.strMeasure12) && Objects.equals(strMeasure13, drink.strMeasure13) && Objects.equals(strMeasure14, drink.strMeasure14) && Objects.equals(strMeasure15, drink.strMeasure15) && Objects.equals(strImageSource, drink.strImageSource) && Objects.equals(strImageAttribution, drink.strImageAttribution) && Objects.equals(strCreativeCommonsConfirmed, drink.strCreativeCommonsConfirmed) && Objects.equals(dateModified, drink.dateModified);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDrink, strDrink, strDrinkAlternate, strTags, strVideo, strCategory, strIBA, strAlcoholic, strGlass, strInstructions, strInstructionsES, strInstructionsDE, strInstructionsFR, strInstructionsIT, strInstructionsZH_HANS, strInstructionsZH_HANT, strDrinkThumb, strIngredient1, strIngredient2, strIngredient3, strIngredient4, strIngredient5, strIngredient6, strIngredient7, strIngredient8, strIngredient9, strIngredient10, strIngredient11, strIngredient12, strIngredient13, strIngredient14, strIngredient15, strMeasure1, strMeasure2, strMeasure3, strMeasure4, strMeasure5, strMeasure6, strMeasure7, strMeasure8, strMeasure9, strMeasure10, strMeasure11, strMeasure12, strMeasure13, strMeasure14, strMeasure15, strImageSource, strImageAttribution, strCreativeCommonsConfirmed, dateModified);
    }

    @Override
    public String toString() {
        return "Drink{" +
                "idDrink=" + idDrink +
                ", strDrink='" + strDrink + '\'' +
                ", strDrinkAlternate='" + strDrinkAlternate + '\'' +
                ", strTags='" + strTags + '\'' +
                ", strVideo='" + strVideo + '\'' +
                ", strCategory='" + strCategory + '\'' +
                ", strIBA='" + strIBA + '\'' +
                ", strAlcoholic='" + strAlcoholic + '\'' +
                ", strGlass='" + strGlass + '\'' +
                ", strInstructions='" + strInstructions + '\'' +
                ", strInstructionsES='" + strInstructionsES + '\'' +
                ", strInstructionsDE='" + strInstructionsDE + '\'' +
                ", strInstructionsFR='" + strInstructionsFR + '\'' +
                ", strInstructionsIT='" + strInstructionsIT + '\'' +
                ", strInstructionsZH_HANS='" + strInstructionsZH_HANS + '\'' +
                ", strInstructionsZH_HANT='" + strInstructionsZH_HANT + '\'' +
                ", strDrinkThumb=" + strDrinkThumb +
                ", strIngredient1='" + strIngredient1 + '\'' +
                ", strIngredient2='" + strIngredient2 + '\'' +
                ", strIngredient3='" + strIngredient3 + '\'' +
                ", strIngredient4='" + strIngredient4 + '\'' +
                ", strIngredient5='" + strIngredient5 + '\'' +
                ", strIngredient6='" + strIngredient6 + '\'' +
                ", strIngredient7='" + strIngredient7 + '\'' +
                ", strIngredient8='" + strIngredient8 + '\'' +
                ", strIngredient9='" + strIngredient9 + '\'' +
                ", strIngredient10='" + strIngredient10 + '\'' +
                ", strIngredient11='" + strIngredient11 + '\'' +
                ", strIngredient12='" + strIngredient12 + '\'' +
                ", strIngredient13='" + strIngredient13 + '\'' +
                ", strIngredient14='" + strIngredient14 + '\'' +
                ", strIngredient15='" + strIngredient15 + '\'' +
                ", strMeasure1='" + strMeasure1 + '\'' +
                ", strMeasure2='" + strMeasure2 + '\'' +
                ", strMeasure3='" + strMeasure3 + '\'' +
                ", strMeasure4='" + strMeasure4 + '\'' +
                ", strMeasure5='" + strMeasure5 + '\'' +
                ", strMeasure6='" + strMeasure6 + '\'' +
                ", strMeasure7='" + strMeasure7 + '\'' +
                ", strMeasure8='" + strMeasure8 + '\'' +
                ", strMeasure9='" + strMeasure9 + '\'' +
                ", strMeasure10='" + strMeasure10 + '\'' +
                ", strMeasure11='" + strMeasure11 + '\'' +
                ", strMeasure12='" + strMeasure12 + '\'' +
                ", strMeasure13='" + strMeasure13 + '\'' +
                ", strMeasure14='" + strMeasure14 + '\'' +
                ", strMeasure15='" + strMeasure15 + '\'' +
                ", strImageSource=" + strImageSource +
                ", strImageAttribution='" + strImageAttribution + '\'' +
                ", strCreativeCommonsConfirmed='" + strCreativeCommonsConfirmed + '\'' +
                ", dateModified=" + dateModified +
                '}';
    }
}
