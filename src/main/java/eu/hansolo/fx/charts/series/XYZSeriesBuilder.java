/*
 * Copyright (c) 2018 by Gerrit Grunwald
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package eu.hansolo.fx.charts.series;

import eu.hansolo.fx.charts.ChartType;
import eu.hansolo.fx.charts.Symbol;
import eu.hansolo.fx.charts.data.XYZItem;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.util.HashMap;
import java.util.List;


public class XYZSeriesBuilder<B extends XYZSeriesBuilder<B>> {
    private HashMap<String, Property> properties = new HashMap<>();


    // ******************** Constructors **************************************
    protected XYZSeriesBuilder() {}


    // ******************** Methods *******************************************
    public static final XYZSeriesBuilder create() {
        return new XYZSeriesBuilder();
    }

    public final B items(final XYZItem... ITEMS) {
        properties.put("itemsArray", new SimpleObjectProperty<>(ITEMS));
        return (B)this;
    }

    public final B items(final List<XYZItem> ITEMS) {
        properties.put("itemsList", new SimpleObjectProperty<>(ITEMS));
        return (B)this;
    }

    public final B name(final String NAME) {
        properties.put("name", new SimpleStringProperty(NAME));
        return (B)this;
    }

    public final B fill(final Paint FILL) {
        properties.put("fill", new SimpleObjectProperty<>(FILL));
        return (B)this;
    }

    public final B stroke(final Paint STROKE) {
        properties.put("stroke", new SimpleObjectProperty<>(STROKE));
        return (B)this;
    }

    public final B textFill(final Color FILL) {
        properties.put("textFill", new SimpleObjectProperty<>(FILL));
        return (B)this;
    }

    public final B symbolFill(final Color FILL) {
        properties.put("symbolFill", new SimpleObjectProperty<>(FILL));
        return (B)this;
    }

    public final B symbolStroke(final Color STROKE) {
        properties.put("symbolStroke", new SimpleObjectProperty<>(STROKE));
        return (B)this;
    }

    public final B symbol(final Symbol SYMBOL) {
        properties.put("symbol", new SimpleObjectProperty<>(SYMBOL));
        return (B)this;
    }

    public final B chartType(final ChartType TYPE) {
        properties.put("chartType", new SimpleObjectProperty<>(TYPE));
        return (B)this;
    }

    public final B symbolsVisible(final boolean VISIBLE) {
        properties.put("symbolsVisible", new SimpleBooleanProperty(VISIBLE));
        return (B)this;
    }

    public final B symbolSize(final double SIZE) {
        properties.put("symbolSize", new SimpleDoubleProperty(SIZE));
        return (B)this;
    }

    public final B strokeWidth(final double WIDTH) {
        properties.put("strokeWidth", new SimpleDoubleProperty(WIDTH));
        return (B)this;
    }

    public final B visible(final boolean VISIBLE) {
        properties.put("visible", new SimpleBooleanProperty(VISIBLE));
        return (B)this;
    }

    public final B animated(final boolean AUTO) {
        properties.put("animated", new SimpleBooleanProperty(AUTO));
        return (B)this;
    }

    public final B animationDuration(final long DURATION) {
        properties.put("animationDuration", new SimpleLongProperty(DURATION));
        return (B)this;
    }


    public final XYZSeries build() {
        final XYZSeries xyzSeries = new XYZSeries();

        if (properties.keySet().contains("itemsArray")) {
            xyzSeries.setItems(((ObjectProperty<XYZItem[]>) properties.get("itemsArray")).get());
        }
        if(properties.keySet().contains("itemsList")) {
            xyzSeries.setItems(((ObjectProperty<List<XYZItem>>) properties.get("itemsList")).get());
        }

        for (String key : properties.keySet()) {
            switch (key) {
                case "name"              -> xyzSeries.setName(((StringProperty) properties.get(key)).get());
                case "fill"              -> xyzSeries.setFill(((ObjectProperty<Paint>) properties.get(key)).get());
                case "stroke"            -> xyzSeries.setStroke(((ObjectProperty<Paint>) properties.get(key)).get());
                case "textFill"          -> xyzSeries.setTextFill(((ObjectProperty<Color>) properties.get(key)).get());
                case "symbolFill"        -> xyzSeries.setSymbolFill(((ObjectProperty<Color>) properties.get(key)).get());
                case "symbolStroke"      -> xyzSeries.setSymbolStroke(((ObjectProperty<Color>) properties.get(key)).get());
                case "symbol"            -> xyzSeries.setSymbol(((ObjectProperty<Symbol>) properties.get(key)).get());
                case "chartType"         -> xyzSeries.setChartType(((ObjectProperty<ChartType>) properties.get(key)).get());
                case "symbolsVisible"    -> xyzSeries.setSymbolsVisible(((BooleanProperty) properties.get(key)).get());
                case "symbolSize"        -> xyzSeries.setSymbolSize(((DoubleProperty) properties.get(key)).get());
                case "strokeWidth"       -> xyzSeries.setStrokeWidth(((DoubleProperty) properties.get(key)).get());
                case "visible"           -> xyzSeries.setVisible(((BooleanProperty) properties.get(key)).get());
                case "animated"          -> xyzSeries.setAnimated(((BooleanProperty) properties.get(key)).get());
                case "animationDuration" -> xyzSeries.setAnimationDuration(((LongProperty) properties.get(key)).get());
            }
        }
        return xyzSeries;
    }
}
