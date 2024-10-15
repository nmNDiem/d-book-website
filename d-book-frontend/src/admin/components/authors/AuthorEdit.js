import React from 'react';
import { Edit, SimpleForm, TextInput } from 'react-admin';

const AuthorEdit = (props) => (
    <Edit {...props}>
        <SimpleForm>
            <TextInput source="name" />
            <TextInput source="bio" />
        </SimpleForm>
    </Edit>
);

export default AuthorEdit;