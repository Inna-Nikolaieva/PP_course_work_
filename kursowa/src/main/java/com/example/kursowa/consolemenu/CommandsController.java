package com.example.kursowa.consolemenu;

import java.util.*;
import java.util.logging.Logger;

public class CommandsController {
    private static final Logger LOG = Logger.getLogger(CommandsController.class.getSimpleName());

    private Map<String, Command> commands;

    public CommandsController() {
        commands = new LinkedHashMap<>();

        commands.put(CreateANewTypeOfCoffeeCommand.NAME, new CreateANewTypeOfCoffeeCommand());
        commands.put(ChangeDataOfTypeOfCoffeeCommand.NAME, new ChangeDataOfTypeOfCoffeeCommand());
        commands.put(DeleteATypeOfCoffeeCommand.NAME, new DeleteATypeOfCoffeeCommand());
        commands.put(CreateAndFillAVanCommand.NAME, new CreateAndFillAVanCommand());
        commands.put(FindCoffeeByQualityParametersCommand.NAME, new FindCoffeeByQualityParametersCommand());
        commands.put(ShowTypesOfCoffeeCommand.NAME, new ShowTypesOfCoffeeCommand());
        commands.put(SortCoffeeCommand.NAME, new SortCoffeeCommand());
    }

    public void execute(String command) {
        Command menuCommand = commands.get(command);

        if(menuCommand == null) {
            //LOG.error("Error executing command");
            //LOG.error("Command " + command + " not found");
            return;
        }

        menuCommand.execute();
    }

}
