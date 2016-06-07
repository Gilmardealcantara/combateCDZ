// sample data array

window.onload = function() {
   
            var sample_data = [
                {"value": 1985, "name": "Rondônia"},
                {"value": 28269, "name": "Acre"},
                {"value": 6661, "name": "Amazonas"},
                {"value": 1123, "name": "Roraima"},
                {"value": 4496, "name": "Pará"},
                {"value": 2190, "name": "Amapá"},
                {"value": 3652, "name": "Tocantins"},
                {"value": 2652, "name": "Maranhāo"},
                {"value": 7657, "name": "Piauí"},
                {"value": 22756, "name": "Ceará"},
                {"value": 11498, "name": "Rio Grande do Norte"},
                {"value": 5625, "name": "Paraíba"},
                {"value": 10488, "name": "Pernambuco"},
                {"value": 13186, "name": "Alagoas"},
                {"value": 2246, "name": "Sergipe"},
                {"value": 13827, "name": "Bahia"},
                {"value": 58177, "name": "Minas Gerais"},
                {"value": 18879, "name": "Espírito Santo"},
                {"value": 7717, "name": "Rio de Janeiro"},
                {"value": 226866, "name": "Sāo Paulo"},
                {"value": 22701, "name": "Paraná"},
                {"value": 134, "name": "Santa Catarina"},
                {"value": 153, "name": "Rio Grande do Sul"},
                {"value": 3423, "name": "Mato Grosso do Sul"},
                {"value": 7160, "name": "Mato Grosso"},
                {"value": 93929, "name": "Goiás"},
                {"value": 11657, "name": "Distrito Federal"},
            ]
            // instantiate d3plus
            var visualization = d3plus.viz()
                    .container("#viz")  // container DIV to hold the visualization
                    .data(sample_data)  // data to use with the visualization
                    .type("tree_map")   // visualization type
                    .id({"value":["name", "value"]})         // key for which our data is unique on
                    .size("value")      // sizing of blocks
                    .draw()             // finally, draw the visualization!

                    debugger;
        
};