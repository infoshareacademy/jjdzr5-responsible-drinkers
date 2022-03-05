package com.infoshareacademy.drinkers.domain.drink;

public class Instruction {
    private String instruction;
    private InstructionsLanguage instructionsLanguage;

    public Instruction(String instruction, InstructionsLanguage instructionsLanguage) {
        this.instruction = instruction;
        this.instructionsLanguage = instructionsLanguage;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public InstructionsLanguage getInstructionsLanguage() {
        return instructionsLanguage;
    }

    public void setInstructionsLanguage(InstructionsLanguage instructionsLanguage) {
        this.instructionsLanguage = instructionsLanguage;
    }
}
