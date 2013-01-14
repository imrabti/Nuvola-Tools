#Nuvola Tools

##How to generate a project

1. Clone Nuvola-Tools into you computer
2. Move to **Nuvola-Tools\archetypes\gwtp-servletcontainer-requestfactory-spring** folder
3. Run ```mvn archetype:create-from-project```
4. Move to target\generated-sources\archetype
5. Run ```mvn install```
6. Move to a new location, where you want to create your project (:warning: This location must be outside Nuvola-Tools folder)
7. Run ```mvn archetype:generate -DarchetypeCatalog=local```
8. Maven will give you several options
   * For the type, choose "1"
   * For groupId, choose something like type com.myapp
   * For artifactId, type the name of your project
   * For packaging, type "com.myapp.myproject"
   * At the end press "y" to accept
9. Once build has succeeded, import your project into IntelliJ IDEA Or Eclipse

*That's All -> Enjoy coding all your life :smiley:*
