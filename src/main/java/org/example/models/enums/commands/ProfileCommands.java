package org.example.models.enums.commands;

import org.example.models.*;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;
import org.example.models.farming.*;
import org.example.models.inventory.*;
import org.example.models.tools.*;
import org.example.models.*;

public enum ProfileCommands implements Command {
    CHANGE_USERNAME("^//s+change//s+username//s+-u//s+(?<username>[a-zA-Z0-9-]+)$"),
    CHANGE_NICKNAME("^//s+change//s+nickname//s+-u//s+(?<nickname>[a-zA-Z0-9-]+)$"),
    CHANGE_EMAIL("^//s+change//s+email//s+(?<email>(?!.*\\\\.\\\\.)[A-Za-z0-9](?:[A-Za-z0-9._-]*[A-Za-z0-9])?@(?:[A-Za-z0-9](?:[A-Za-z0-9-]*[A-Za-z0-9])?\\\\.)+[A-Za-z]{2,})$"),
    CHANGE_PASSWORD("^//s+change$")



    }
