package Entities;

import Enums.MoonPhase;
import Enums.Weather;

public record Environment(MoonPhase phase, Weather weather) {
}
