# Paracord UI

## Run the project

`yarn` will download all of the dependencies that are located in the package.json.

`yarn start` will run the react app on http://localhost:3000

`yarn add {dependency name}` will add a new yarn dependency

## Tailwind CSS Generation

As per the package.json set up, running `yarn start` will now automatically regenerate the tailwind CSS file.

If you would like to generate it manually (although I have no clue why you would), you may run `npx tailwind build src/css/App.css -o src/generated/tailwind.css`
