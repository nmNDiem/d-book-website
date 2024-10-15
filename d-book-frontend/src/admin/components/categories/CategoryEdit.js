import React from 'react';
import { BooleanInput, Edit, SimpleForm, TextInput } from 'react-admin';

export const CategoryEdit = (props) => (
    <Edit {...props}>
        <SimpleForm>
            <TextInput source="name" />
            <TextInput source="description" />
            <BooleanInput source="active" />
        </SimpleForm>
    </Edit>
);