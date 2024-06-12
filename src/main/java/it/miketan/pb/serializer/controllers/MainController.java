package it.miketan.pb.serializer.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.LinkedHashMap;

public class MainController {

   @FXML
   private TextField actCountField;
   @FXML
   private TextField actDurationField;
   @FXML
   private TextField heatField;
   @FXML
   private TextField massField;
   @FXML
   private TextField scrapValueField;
   @FXML
   private TextField wpnConcussionField;
   @FXML
   private TextField wpnDamageField;
   @FXML
   private TextField wpnDamageRadiusField;
   @FXML
   private TextField wpnImpactField;
   @FXML
   private TextField wpnImpactRadiusField;
   @FXML
   private TextField wpnProjLifeTimeField;
   @FXML
   private TextField wpnProjRicochetField;
   @FXML
   private TextField wpnRangeMaxField;
   @FXML
   private TextField wpnRangeMinField;
   @FXML
   private TextField wpnScatterAngleField;
   @FXML
   private TextField wpnScatterAngleMovingField;
   @FXML
   private TextField wpnSpeedField;

   //Fill text fields to 0
   @FXML
   protected void initialize() {
      actCountField.setText("0");
      actDurationField.setText("0");
      heatField.setText("0");
      massField.setText("0");
      scrapValueField.setText("0");
      wpnConcussionField.setText("0");
      wpnDamageField.setText("0");
      wpnDamageRadiusField.setText("0");
      wpnImpactField.setText("0");
      wpnImpactRadiusField.setText("0");
      wpnProjLifeTimeField.setText("0");
      wpnProjRicochetField.setText("0");
      wpnRangeMaxField.setText("0");
      wpnRangeMinField.setText("0");
      wpnScatterAngleField.setText("0");
      wpnScatterAngleMovingField.setText("0");
      wpnSpeedField.setText("0");
   }

   @FXML
   protected void onLoadBtnClick() {
      //TODO: Create logic around importing file with its values.
   }

   @FXML
   protected void onSaveBtnClick() throws NumberFormatException {

      //DumperOption controls YAML indentation Style
      DumperOptions dumperOptions = new DumperOptions();
      dumperOptions.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
      dumperOptions.setPrettyFlow(true);
      Yaml yaml = new Yaml(dumperOptions);

      Map<String, Object> tagsRoot = new LinkedHashMap<>();
      Map<String, Object> nestedTags = new LinkedHashMap<>();

      Map<String, Object> statDistributionRoot = new LinkedHashMap<>();
      Map<String, Object> nestedStatDistribution = new LinkedHashMap<>();

      Map<String, Object> statsRoot = new LinkedHashMap<>();
      Map<String, Object> nestedStats = new LinkedHashMap<>();
         nestedStats.put("act_count", createNesting(Integer.parseInt(actCountField.getText())));
         nestedStats.put("act_duration", createNesting(Integer.parseInt(actDurationField.getText())));
         nestedStats.put("act_heat", createNesting(Integer.parseInt(heatField.getText())));
         nestedStats.put("mass", createNesting(Integer.parseInt(massField.getText())));
         nestedStats.put("scrap_value", createNesting(Integer.parseInt(scrapValueField.getText())));
         nestedStats.put("wpn_concussion", createNesting(Integer.parseInt(wpnConcussionField.getText())));
         nestedStats.put("wpn_damage", createNesting(Integer.parseInt(wpnDamageField.getText())));
         nestedStats.put("wpn_damage_radius", createNesting(Integer.parseInt(wpnDamageRadiusField.getText())));
         nestedStats.put("wpn_impact", createNesting(Integer.parseInt(wpnImpactField.getText())));
         nestedStats.put("wpn_impact_radius", createNesting(Integer.parseInt(wpnImpactRadiusField.getText())));
         nestedStats.put("wpn_proj_lifetime", createNesting(Integer.parseInt(wpnProjLifeTimeField.getText())));
         nestedStats.put("wpn_proj_ricochet", createNesting(Integer.parseInt(wpnProjRicochetField.getText())));
         nestedStats.put("wpn_range_max", createNesting(Integer.parseInt(wpnRangeMaxField.getText())));
         nestedStats.put("wpn_range_min", createNesting(Integer.parseInt(wpnRangeMinField.getText())));
         nestedStats.put("wpn_scatter_angle", createNesting(Integer.parseInt(wpnScatterAngleField.getText())));
         nestedStats.put("wpn_scatter_angle_moving", createNesting(Integer.parseInt(wpnScatterAngleMovingField.getText())));
         nestedStats.put("wpn_speed", createNesting(Integer.parseInt(wpnSpeedField.getText())));

         nestedTags.put("tags", "");

         nestedStatDistribution.put("statDistribution", "");

         statsRoot.put("stats", nestedStats);

      try (FileWriter writer = new FileWriter("wpn_main" + "_stats_" + "output" + ".yaml")) {
         yaml.dump(nestedTags, writer);
         yaml.dump(nestedStatDistribution, writer);
         yaml.dump(statsRoot, writer);
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   private static Map<String, Object> createNesting(Integer value) {

      Map<String,Object> nestedValue = new LinkedHashMap<>();
         nestedValue.put("value", value);
         nestedValue.put("targetMode", 0);
         nestedValue.put("targetSocket", "");
         nestedValue.put("targetHardpoint", "");
         return nestedValue;
   }

   private void addDigitFilter(TextField field) {
      field.textProperty().addListener((observable, oldValue, newValue) -> {
         if (!newValue.matches("\\d*")) {
            field.setText(newValue.replaceAll("[^\\d]", ""));
         }
      });
   }

   @FXML
   protected void onInput() {
      addDigitFilter(actCountField);
      addDigitFilter(actDurationField);
      addDigitFilter(heatField);
      addDigitFilter(massField);
      addDigitFilter(scrapValueField);
      addDigitFilter(wpnConcussionField);
      addDigitFilter(wpnDamageField);
      addDigitFilter(wpnDamageRadiusField);
      addDigitFilter(wpnImpactField);
      addDigitFilter(wpnImpactRadiusField);
      addDigitFilter(wpnProjLifeTimeField);
      addDigitFilter(wpnProjRicochetField);
      addDigitFilter(wpnRangeMaxField);
      addDigitFilter(wpnRangeMinField);
      addDigitFilter(wpnScatterAngleField);
      addDigitFilter(wpnScatterAngleMovingField);
      addDigitFilter(wpnSpeedField);
   }

}